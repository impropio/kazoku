<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
		<meta name="description" content="Kazoku">
		<meta name="author" content="Francisco Moro">
		<title><spring:message code="title"  text="Kazoku"/></title>
	
		<!-- styles -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/vendor/bootstrap-3.3.7/css/bootstrap.min.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/vendor/font-awesome/css/font-awesome.min.css">
		<!-- propios -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/general.css">
		
		<!-- javaScript -->
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/vendor/jquery/jquery-1.11.2.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/vendor/bootstrap-3.3.7/js/bootstrap.min.js"></script>
		<!-- propios -->
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/config.js"></script>
	</head>
	<body>
		<header>
			<nav class="navbar navbar-inverse navbar-fixed-top">
				<div class="container-fluid">
					<div class="navbar-header">
						<span class="t3 titulo" style="color: grey;">Kazoku</span>
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="${pageContext.request.contextPath}">Inicio</a></li>
							<li class="breadcrumb-item active">Configuración</li>
						</ol>
					</div>
				</div>
			</nav>
		</header>
		<div class="contenedor" id="contenedor">
			<div class="col-md-4">
				<div class="panel panel-default">
					<div class="panel-heading">Ubicación</div>
					<div class="panel-body">
						<div class="row">
							<span class="titulo3">Localización:</span>
							<div class="col-md-6">
								 <select class="form-control" id="pais">
								 	<option value="--" selected>Seleccione una opción</option>
								 	<c:forEach var="pais" items="${paises}">
								 		<c:choose>
								 			<c:when test="${configuracion.codigoPais == pais.codigoPais}">
								 				<option value="${pais.codigoPais}" selected>${pais.pais}</option>
								 			</c:when>
								 			<c:otherwise>
								 				<option value="${pais.codigoPais}">${pais.pais}</option>
								 			</c:otherwise>
								 		</c:choose>
								 	</c:forEach>
								 </select>
							</div>
							<div class="col-md-6">
								<%--<select class="form-control">
									<option value="--" selected>Seleccione una opción</option>
									<c:forEach var="ciudad" items="${ciudades}">
										<c:choose>
											<c:when test="${configuracion.idCiudad == ciudad.idCiudad}">
								 				<option value="${ciudad.idCiudad}" selected>${ciudad.nombreCiudad}</option>
								 			</c:when>
								 			<c:otherwise>
								 				<option value="${ciudad.idCiudad}">${ciudad.nombreCiudad}</option>
								 			</c:otherwise>
										</c:choose>
									</c:forEach>
								</select>--%>
								<c:choose>
									<c:when test="${configuracion.codigoPais != '-'}">
										<input list="lista-ciudades" id="ciudad" name="ciudad" class="form-control" value="${ciudadSeleccionada.nombreCiudad}">
									</c:when>
									<c:otherwise>
										<input list="lista-ciudades" id="ciudad" name="ciudad" class="form-control" disabled>
									</c:otherwise>
								</c:choose>
								<datalist id="lista-ciudades">
									<%--
									<c:forEach var="ciudad" items="${ciudades}">
								 		<option data-valor="${ciudad.idCiudad}" value="${ciudad.nombreCiudad}"/>
									</c:forEach>
									--%>
								</datalist>
							</div>
						</div>
						<div class="row">
							<span class="titulo3">Unidades:</span>
							<c:forEach var="medida" items="${medidas}">
								<div class="radio radio-custom">
									<c:choose>
										<c:when test="${configuracion.idMedida == medida.idMedida}">
											<label><input type="radio" name="medidas" value="${medida.idMedida}" checked><span> ${medida.medida}</span></label>
										</c:when>
										<c:otherwise>
											<label><input type="radio" name="medidas" value="${medida.idMedida}"><span> ${medida.medida}</span></label>
										</c:otherwise>
									</c:choose>
								</div>
							</c:forEach>
						</div>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>