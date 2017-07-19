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
		<!-- propios -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/general.css">
		
		<!-- javaScript -->
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/vendor/jquery/jquery-1.11.2.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/vendor/bootstrap-3.3.7/js/bootstrap.min.js"></script>
	</head>
	<body>
		<header>
			<nav class="navbar navbar-inverse navbar-fixed-top">
				<div class="container-fluid">
					<div class="navbar-header">
						<h3 class="titulo" style="color: grey;">Kazoku -> Configuración</h3>
					</div>
				</div>
			</nav>
		</header>
		<div class="contenedor" id="contenedor" style="margin-top: 80px;">
			<div class="panel panel-default">
				<div class="panel-heading">Ubicación</div>
				<div class="panel-body">
					Formulario de configuración
				</div>
			</div>
		</div>
		<footer>
			<nav class="navbar navbar-inverse navbar-fixed-bottom">
				<div class="container-fluid">
					<div class="navbar-header" style="width: 100%;">
						<h6 style="diaplay:inline; float: left; color: grey;">Desarrollado por Francisco Moro</h6>
						<h6 style="diaplay:inline; float: right; color: grey;">Ver. 0.1 / 19-Jul-2017</h6>
					</div>
				</div>
			</nav>
		</footer>
	</body>
</html>