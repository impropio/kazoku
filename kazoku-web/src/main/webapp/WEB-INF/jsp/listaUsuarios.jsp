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
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/vendor/DataTables/datatables.min.css">
		<!-- propios -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/general.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/listaUsuarios.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/modal.css">
		
		<!-- javaScript -->
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/vendor/jquery/jquery-1.11.2.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/vendor/bootstrap-3.3.7/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/vendor/bootstrap-3.3.7/js/notify.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/vendor/DataTables/datatables.min.js"></script>
		<!-- propios -->
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/custom-notify.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/general.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/usuario.js"></script>
	</head>
	<body>
		<%@ include file="common/mensajes.jsp" %>
		<header>
			<nav class="navbar navbar-inverse navbar-fixed-top">
				<div class="container-fluid">
					<div class="navbar-header">
						<span class="t3 titulo" style="color: grey;"><spring:message code="title"/></span>
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="${pageContext.request.contextPath}"><spring:message code="nombre.pagina.inicio"/></a></li>
							<li class="breadcrumb-item active"><spring:message code="nombre.pagina.usuario"/></li>
						</ol>
					</div>
				</div>
			</nav>
		</header>
		<div class="contenedor" id="contenedor">
			<div class="row">
				<button type="button" class="btn btn-info pull-right" data-toggle="modal" data-target="#modal_usuario"><em class="fa fa-user-plus fa-2x"></em></button>
			</div>
			<div class="row linea contenedor-tarjetas">
				<c:forEach var="usuario" items="${listaUsuarios}">
					<div class="col-lg-3 col-md-4 col-sm-6 tarjetaUsuario">
						<div class="datosUsuario">
							<h4><span class="nombre-usuario" data-idUsuario="${usuario.id}">${usuario.nombre}</span></h4>
							<div class="dato">
								<span><em class="icono fa fa-phone-square" data-toggle="popover" data-trigger="hover" data-content="<spring:message code="usuario.telefono"/>"></em>123-456-789</span>
							</div>
							<div class="dato">
								<span><em class="icono fa fa-envelope" data-toggle="popover" data-trigger="hover" data-content="<spring:message code="usuario.email"/>"></em>info@info.com</span>
							</div>
							<div class="dato">
								<span><em class="icono fa fa-user-circle" data-toggle="popover" data-trigger="hover" data-content="<spring:message code="usuario.dni"/>"></em>${usuario.dni}</span>
							</div>
							<div class="dato">
								<span><em class="icono fa fa-id-card" data-toggle="popover" data-trigger="hover" data-content="<spring:message code="usuario.pasaporte"/>"></em>${usuario.pasaporte}</span>
							</div>
							<div class="dato">
								<span><em class="icono fa fa-user-md" data-toggle="popover" data-trigger="hover" data-content="<spring:message code="usuario.seguridad.social"/>"></em>${usuario.segSocial}</span>
							</div>
							<div class="dato">
								<span><em class="icono fa fa-birthday-cake" data-toggle="popover" data-trigger="hover" data-content="<spring:message code="usuario.nacimiento"/>"></em>${usuario.fechaNacimiento}</span>
							</div>
							<div class="dato">
								<span><em class="icono fa fa-heart" data-toggle="popover" data-trigger="hover" data-content="<spring:message code="usuario.grupo.sanguineo"/>"></em>${usuario.grupoSanguineo}</span>
							</div>
							<div class="dato">
								<span><em class="icono fa fa-exclamation-triangle" data-toggle="popover" data-trigger="hover" data-content="<spring:message code="usuario.alergias"/>"></em>${usuario.textoAlergias}</span>
							</div>
						</div>
					</div>
				</c:forEach>
				<c:forEach var="usuario" items="${listaUsuarios}">
					<div class="col-lg-3 col-md-4 col-sm-6 tarjetaUsuario" data-idUsuario="${usuario.id}">
						<div class="datosUsuario">
							<h4>${usuario.nombre}</h4>
							<div class="dato">
								<span><em class="icono fa fa-phone-square"></em>123-456-789</span>
							</div>
							<div class="dato">
								<span><em class="icono fa fa-envelope"></em>info@info.com</span>
							</div>
							<div class="dato">
								<span><em class="icono fa fa-user-circle"></em>${usuario.dni}</span>
							</div>
							<div class="dato">
								<span><em class="icono fa fa-id-card"></em>${usuario.pasaporte}</span>
							</div>
							<div class="dato">
								<span><em class="icono fa fa-user-md"></em>${usuario.segSocial}</span>
							</div>
							<div class="dato">
								<span><em class="icono fa fa-birthday-cake"></em>${usuario.fechaNacimiento}</span>
							</div>
							<div class="dato">
								<span><em class="icono fa fa-heart"></em>${usuario.grupoSanguineo}</span>
							</div>
							<div class="dato">
								<span><em class="icono fa fa-exclamation-triangle"></em>${usuario.textoAlergias}</span>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
		<%-- Modales --%>
		<%@ include file="modales/usuario.jsp" %>
		<%@ include file="modales/acceso.jsp" %>
	</body>
</html>