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
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/vendor/bootstrap-3.3.7/js/notify.min.js"></script>
		<!-- propios -->
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/custom-notify.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/config.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/general.js"></script>
	</head>
	<body>
		<%@ include file="common/mensajes.jsp" %>
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
								 	<option value="-" selected>Seleccione una opción</option>
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
								<c:choose>
									<c:when test="${configuracion.codigoPais != '-'}">
										<input list="lista-ciudades" id="ciudad" name="ciudad" class="form-control" data-valor="" value="${ciudadSeleccionada.nombreCiudad}">
									</c:when>
									<c:otherwise>
										<input list="lista-ciudades" id="ciudad" name="ciudad" class="form-control" data-valor="" disabled>
									</c:otherwise>
								</c:choose>
								<datalist id="lista-ciudades" name="lista-ciudades">
								</datalist>
							</div>
						</div>
						<div class="row linea">
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
						<div class="row linea">
							<div class="col-md-6">
								<span class="titulo3">Días de predicción</span>
								<div class="range">
									<input type="range" id="dias-prediccion" class="selector" min="4" max="12" value="${configuracion.climaNumeroDias}">
									<span class="valor">${configuracion.climaNumeroDias}</span>
								</div>
							</div>
							<div class="col-md-6">
								<span class="titulo3">Código API <a href="https://openweathermap.org">OpenWeatherMap</a></span>
								<input id="api-clima" name="api-clima" class="form-control" value="${configuracion.climaApiId}">
							</div>
						</div>
						<div class="row linea">
							<button id="actualizar-ubicacion" type="button" class="btn btn-success pull-right">Actualizar</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>