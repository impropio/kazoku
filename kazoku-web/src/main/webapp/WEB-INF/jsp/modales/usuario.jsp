<div id="modal_usuario" class="modal fade" role="dialog">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title"><spring:message code="usuario.titulo.modal"/></h4>
			</div>
			<div class="modal-body">
				<form action="${pageContext.request.contextPath}/usuario/actualizar" method="post">
					<input type="text" id="id_usuario" name="id_usuario" class="oculto">
					<div class="row linea">
						<div class="col-sm-2">
							<span><spring:message code="usuario.nombre"/>:</span>
						</div>
						<div class="col-sm-10">
							<input type="text" id="nombre" name="nombre" class="form-control">
						</div>
					</div>
					<div class="row linea">
						<div class="col-sm-2">
							<span><spring:message code="usuario.privacidad"/>:</span>
						</div>
						<div class="col-sm-10">
							<div class="check-custom">
								<label class="checkbox-inline"><input type="checkbox" name="usa-clave"><span><spring:message code="usuario.uso.contraseña"/></span></label>
							</div>
							<em class="fa fa-info-circle info_clave"></em>
						</div>
					</div>
					<div class="row linea">
						<div class="col-sm-2">
							<span><spring:message code="usuario.contraseña"/>:</span>
						</div>
						<div class="col-sm-5">
							<input type="password" id="clave" name="clave" class="form-control" disabled>
						</div>
						<div class="col-sm-5">
							<input type="password" id="clave2" name="clave2" class="form-control" disabled>
						</div>
					</div>
					<div class="row linea">
						<div class="col-sm-2">
							<span><spring:message code="usuario.nacimiento"/>:</span>
						</div>
						<div class="col-sm-4">
							<input type="date" id="nacimiento" name="nacimiento" class="form-control">
						</div>
						<div class="col-sm-2">
							<span><spring:message code="usuario.dni"/>:</span>
						</div>
						<div class="col-sm-4">
							<input type="text" id="dni" name="dni" class="form-control">
						</div>
					</div>
					<div class="row linea">
						<div class="col-sm-2">
							<span><spring:message code="usuario.pasaporte"/>:</span>
						</div>
						<div class="col-sm-4">
							<input type="text" id="pasaporte" name="pasaporte" class="form-control">
						</div>
						<div class="col-sm-2">
							<span><spring:message code="usuario.seguridad.social"/>:</span>
						</div>
						<div class="col-sm-4">
							<input type="text" id="segsocial" name="segsocial" class="form-control">
						</div>
					</div>
					<div class="row linea">
						<div class="col-sm-2">
							<span><spring:message code="usuario.grupo.sanguineo"/>:</span>
						</div>
						<div class="col-sm-4">
							<select id="gruposangineo" name="gruposangineo" class="form-control">
								<option value="-" selected><spring:message code="formulario.seleccione.opcion"/></option>
								<c:forEach var="grupoSanguineo" items="${gruposSanguineos}">
									<option value="${grupoSanguineo}">${grupoSanguineo.grupoSanguineo}</option>
								</c:forEach>
							</select>
						</div>
						<div class="col-sm-2">
							<span><spring:message code="usuario.alergias"/>:</span>
						</div>
						<div class="col-sm-4">
							<div class="input-group">
								<input type="text" id="alergias" name="alergias" class="form-control" value="lacteos" disabled>
								<span class="input-group-addon ampliar-alergias">...</span>
								<input type="text" id="cod_alergias" name="cod_alergias" class="oculto">
							</div>
						</div>
					</div>
					<div class="row linea">
						<div class="pull-right">
							<button id="eliminar-usuario" type="button" class="btn btn-danger"><spring:message code="formulario.boton.eliminar"/></button>
							<button id="limpiar-formulario" type="button" class="btn btn-info"><spring:message code="formulario.boton.limpiar"/></button>
							<button id="actualizar-usuario" type="button" class="btn btn-success"><spring:message code="formulario.boton.actualizar"/></button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>