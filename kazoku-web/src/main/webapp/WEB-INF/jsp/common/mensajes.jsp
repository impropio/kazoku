<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<script type="text/javascript" charset="UTF-8">
var diccionario = {
		diaSemanaNombres:'<spring:message code="nombre.dias.semana.corto"/>',
		mesNombres:'<spring:message code="nombre.meses"  text=""/>',
		separadorFecha:'<spring:message code="separador.fecha"  text=""/>',
		pageContext:'${pageContext.request.contextPath}'
	};
</script>