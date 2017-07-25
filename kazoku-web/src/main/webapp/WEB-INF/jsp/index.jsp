<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<jsp:useBean id="util" class="com.francisco.kazoku.web.utiles.Utiles"/>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
		<meta name="description" content="Rapiro">
		<meta name="author" content="Francisco Moro">
		<title><spring:message code="title"  text="Kazoku"/></title>
	
		<!-- styles -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/vendor/bootstrap-3.3.7/css/bootstrap.min.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/vendor/font-awesome/css/font-awesome.min.css">
		
		<!-- propios -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/general.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/reloj.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/predicciones.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/opciones.css">
		
		<!-- javaScript -->
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/vendor/jquery/jquery-1.11.2.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/vendor/bootstrap-3.3.7/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/vendor/moment/moment.min.js"></script>
		<!-- propios -->
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/reloj.js"></script>
		
	</head>
	<body>
	<%@ include file="common/mensajes.jsp" %>
		<div class="contenedor-principal">
			<div class="col-md-8 alto-100">
				<div class="row alto-25">
					<div id="reloj" class="col-md-7">
						<!-- <h1>Fecha / hora</h1> -->
						<div class="display">
							<div class="diasSemana"></div>
							<!-- <div class="ampm"></div> -->
							<div class="alarm"></div>
							<div class="digitos"></div>
							<div class="fecha"></div>
						</div>
					</div>
					<div class="col-md-5 opciones">
						<a href="${pageContext.request.contextPath}/configuracion"><em class="fa fa-2x fa-cog configuracion"></em></a>
						<a href=""><em class="fa fa-2x fa-sun-o"></em></a>
						<a href=""><em class="fa fa-2x fa-moon-o"></em></a>
						<a href=""><em class="fa fa-2x fa-user-o"></em></a>
						<a href=""><em class="fa fa-2x fa-address-card-o"></em></a>
						<a href=""><em class="fa fa-2x fa-shopping-cart"></em></a>
						<a href=""><em class="fa fa-2x fa-wifi"></em></a>
					</div>
				</div>
				<div class="row alto-50">
					<div class="col-md-7 prediccion">
						<img src="${pageContext.request.contextPath}/resources/img/iconos_clima/max/${prediccionActual.predicciones[0].icono}.png" alt="prediccion">
						<%-- <h3 class="titulo_dia">${prediccionActual.predicciones[0].climaDescripcion}</h3> --%>
						<%-- <span>${prediccionActual.predicciones[0].temperaturaMaxima}º \ ${prediccionActual.predicciones[0].temperaturaMinima}º</span> --%>
					</div>
					<div class="sin-margen alto-porc-100 col-md-5">
						<div class="alto-porc-50 exterior">
							<span class="t3">${prediccionActual.nombre}:</span>
							<span class="ancho-100">
								<span class="ancho-50"><spring:message code="temp.actual"/>: ${prediccionActual.predicciones[0].temperatura}º</span>
								<span class="ancho-50"><spring:message code="prediccion"/>: ${prediccionActual.predicciones[0].clima}</span>
							</span>
							<span class="ancho-100">${prediccionActual.predicciones[0].climaDescripcion}</span>
							<span class="ancho-100">
								<span class="ancho-50"><spring:message code="humedad"/>: ${prediccionActual.predicciones[0].humedad}</span>
								<span class="ancho-50"><spring:message code="presion"/>: ${prediccionActual.predicciones[0].presion}</span>
							</span>
							<span class="ancho-100">
								<span class="ancho-50"><spring:message code="temp.max"/>: ${prediccionActual.predicciones[0].temperaturaMaxima}º</span>
								<span class="ancho-50"><spring:message code="temp.min"/>: ${prediccionActual.predicciones[0].temperaturaMinima}º</span>
							</span>
							<span class="ancho-100">
								<span class="ancho-50"><spring:message code="nubosidad"/>: ${prediccionActual.predicciones[0].nubosidad}</span>
								<span class="ancho-50"><spring:message code="visibilidad"/>: ${prediccionActual.predicciones[0].visibilidad}</span>
							</span>
							<span class="ancho-100">
								<span class="ancho-50"><spring:message code="viento.velocidad"/>: ${prediccionActual.predicciones[0].velocidadViento}</span>
								<span class="ancho-50"><spring:message code="viento.direccion"/>: <spring:message code="viento.direccion.${prediccionActual.predicciones[0].direccionViento}"/></span>
							</span>
							<span class="ancho-100">
								<span class="ancho-50"><spring:message code="amanecer"/>: ${util.fechaCorta(prediccionActual.amanecer, 'HH:mm:ss')}</span>
								<span class="ancho-50"><spring:message code="atardecer"/>: ${util.fechaCorta(prediccionActual.atardecer, 'HH:mm:ss')}</span>
							</span>
						</div>
						<div class="alto-porc-50 interior">
							<span class="t3"><spring:message code="interior"/>:</span>
							<span class="ancho-100">
								<span class="ancho-100"><spring:message code="temp.actual"/>: Temperatura interior º</span>
							</span>
							<span class="ancho-100">
								<span class="ancho-50"><spring:message code="humedad"/>: Humedad interior</span>
								<span class="ancho-50"><spring:message code="presion"/>: Presión interior</span>
							</span>
						</div>
					</div>
				</div>
				<div class="row alto-25">
					<%-- <h1>Tiempo próximos 7 dias</h1> --%>
					<div class="lista_predicciones">
						<c:forEach var="prediccion" items="${predicciones}" varStatus="loop">
							<c:if test="${loop.index > 0}">
								<div class="predicciones">
									<span class="titulo_dia"><spring:message code="nombre.dias.semana.${util.fechaCorta(prediccion.fecha, 'u')}"/></span>
									<span class="imagen">
										<img src="${pageContext.request.contextPath}/resources/img/iconos_clima/min/${prediccion.icono}.png" alt="prediccion">
									</span>
									<span class="resumen">
										<span class="ancho-50"><em class="fa fa-thermometer-full"></em>${prediccion.temperaturaMaxima}º</span>
										<span class="ancho-50"><em class="fa fa-thermometer-empty"></em>${prediccion.temperaturaMinima}º</span>
									</span>
								</div>
							</c:if>
						</c:forEach>
					</div>
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