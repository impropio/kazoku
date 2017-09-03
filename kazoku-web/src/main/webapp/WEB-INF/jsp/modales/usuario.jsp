<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/modales/usuario.js"></script>
<div id="modal_usuario" class="modal fade" role="dialog">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title"><spring:message code="usuario.titulo.modal"/></h4>
			</div>
			<div class="modal-body">
				<form action="${pageContext.request.contextPath}/usuario/actualizar" method="post">
					<input type="number" id="mod_usu_id_usuario" name="mod_usu_id_usuario" class="oculto" value='0'>
					<div class="row linea">
						<div class="col-sm-2">
							<span><spring:message code="usuario.nombre"/>:</span>
						</div>
						<div class="col-sm-10">
							<input type="text" id="mod_usu_nombre" name="mod_usu_nombre" class="form-control">
						</div>
					</div>
					<div class="row linea">
						<div class="col-sm-2">
							<span><spring:message code="usuario.privacidad"/>:</span>
						</div>
						<div class="col-sm-10">
							<div class="check-custom">
								<label class="checkbox-inline"><input type="checkbox" name="mod_usu_usa-clave"><span><spring:message code="usuario.uso.contraseña"/></span></label>
							</div>
							<em class="fa fa-info-circle mod_usu_info_clave"></em>
						</div>
					</div>
					<div class="row linea">
						<div class="col-sm-2">
							<span><spring:message code="usuario.contraseña"/>:</span>
						</div>
						<div class="col-sm-5">
							<input type="password" id="mod_usu_clave" name="mod_usu_clave" class="form-control" disabled>
						</div>
						<div class="col-sm-5">
							<input type="password" id="mod_usu_clave2" name="mod_usu_clave2" class="form-control" disabled>
						</div>
					</div>
					<div class="row linea">
						<div class="col-sm-2">
							<span><spring:message code="usuario.nacimiento"/>:</span>
						</div>
						<div class="col-sm-4">
							<input type="date" id="mod_usu_nacimiento" name="mod_usu_nacimiento" class="form-control">
						</div>
						<div class="col-sm-2">
							<span><spring:message code="usuario.dni"/>:</span>
						</div>
						<div class="col-sm-4">
							<input type="text" id="mod_usu_dni" name="mod_usu_dni" class="form-control">
						</div>
					</div>
					<div class="row linea">
						<div class="col-sm-2">
							<span><spring:message code="usuario.pasaporte"/>:</span>
						</div>
						<div class="col-sm-4">
							<input type="text" id="mod_usu_pasaporte" name="mod_usu_pasaporte" class="form-control">
						</div>
						<div class="col-sm-2">
							<span><spring:message code="usuario.seguridad.social"/>:</span>
						</div>
						<div class="col-sm-4">
							<input type="text" id="mod_usu_segsocial" name="mod_usu_segsocial" class="form-control">
						</div>
					</div>
					<div class="row linea">
						<div class="col-sm-2">
							<span><spring:message code="usuario.grupo.sanguineo"/>:</span>
						</div>
						<div class="col-sm-4">
							<select id="mod_usu_gruposanguineo" name="mod_usu_gruposanguineo" class="form-control">
								<option value="-" selected><spring:message code="formulario.seleccione.opcion"/></option>
								<c:forEach var="grupoSanguineo" items="${gruposSanguineos}">
									<option value="${grupoSanguineo}">${grupoSanguineo}</option>
								</c:forEach>
							</select>
						</div>
						<div class="col-sm-2">
							<span><spring:message code="usuario.alergias"/>:</span>
						</div>
						<div class="col-sm-4">
							<div class="input-group">
								<input type="text" id="mod_usu_alergias" name="mod_usu_alergias" class="form-control" value="" disabled>
								<span class="input-group-addon ampliar-alergias">...</span>
								<input type="text" id="mod_usu_cod_alergias" name="mod_usu_cod_alergias" class="oculto">
							</div>
						</div>
					</div>
					<div class="row linea">
						<div class="pull-right">
							<button id="mod_usu_eliminar_usuario" type="button" class="btn btn-danger"><spring:message code="formulario.boton.eliminar"/></button>
							<button id="mod_usu_limpiar_formulario" type="button" class="btn btn-info"><spring:message code="formulario.boton.limpiar"/></button>
							<button id="mod_usu_actualizar_usuario" type="button" class="btn btn-success"><spring:message code="formulario.boton.actualizar"/></button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>