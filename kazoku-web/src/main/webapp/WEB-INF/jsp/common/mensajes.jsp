<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<script type="text/javascript" charset="UTF-8">
var diccionario = {
		pageContext:'${pageContext.request.contextPath}',
		diaSemanaNombres:'<spring:message code="nombre.dias.semana.corto"/>',
		mesNombres:'<spring:message code="nombre.meses"  text=""/>',
		separadorFecha:'<spring:message code="separador.fecha"  text=""/>',
		ubicacionActualizada:'<spring:message code="configuracion.ubicacion.actualizada"/>',
		ubicacionNoActualizada:'<spring:message code="configuracion.ubicacion.no.actualizada"/>',
		modoNocheActivado:'<spring:message code="inicio.modo.noche.desactivado"/>',
		modoNocheDesactivado:'<spring:message code="inicio.modo.noche.activado"/>',
		avisoContrasena:'<spring:message code="usuario.aviso.contrasena"/>'
	};
</script>