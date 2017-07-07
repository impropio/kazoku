<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
		<meta name="description" content="Rapiro">
		<meta name="author" content="Francisco Moro">
		<title><spring:message code="title"  text="Kazoku"/></title>
	
		<!-- styles -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/vendor/bootstrap-3.3.7/css/bootstrap.min.css">
		<!-- propios -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/general.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/reloj.css">
		
		<!-- javaScript -->
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/vendor/jquery/jquery-1.11.2.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/vendor/bootstrap-3.3.7/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/vendor/moment/moment.min.js"></script>
		<!-- propios -->
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/reloj.js"></script>
	</head>
	<body>
		<div class="contenedor">
			<div class="col-md-8 alto-100">
				<div class="row alto-25">
					<div id="reloj" class="col-md-8">
						<!-- <h1>Fecha / hora</h1> -->
						<div class="display">
							<div class="diasSemana"></div>
							<!-- <div class="ampm"></div> -->
							<div class="alarm"></div>
							<div class="digitos"></div>
						</div>
					</div>
					<div class="col-md-4">
						<h3>Iconos del menú</h3>
					</div>
				</div>
				<div class="row alto-50">
					<h1>Tiempo actual</h1>
					<div class="col-md-8">
						<h3>Imagen de la predicción</h3>
					</div>
					<div class="col-md-4">
						<h3>Datos del tiempo, temperatura, humedad...</h3>
						<h3>Datos dentro de casa, temperatura, humedad...</h3>
					</div>
				</div>
				<div class="row alto-25">
					<h1>Tiempo próximos 7 dias</h1>
				</div>
			</div>
			<div class="col-md-4 alto-100">
				<div class="row alto-100">
					<h1>Próximos eventos</h1>
				</div>
			</div>
		</div>
	</body>
</html>