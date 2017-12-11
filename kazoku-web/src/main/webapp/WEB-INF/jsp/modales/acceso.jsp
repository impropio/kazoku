<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/modales/acceso.js"></script>
<div id="modal_acceso" class="modal fade" role="dialog">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title"><spring:message code="modal.acceso.titulo"/></h4>
			</div>
			<div class="modal-body">
				<form id="formulario_acceso" action="${pageContext.request.contextPath}/" method="post">
					<input type="text" id="mod_acceso_id_usuario" name="mod_acceso_id_usuario" class="oculto">
					<div class="row linea">
						<div class="col-sm-4"></div>
						<div class="col-sm-8">
							<small id="mod_acceso_usuario_ayuda" class="text-danger hidden"><spring:message code="formulario.campo.obligatorio"/></small>
						</div>
					</div>
					<div class="row linea">
						<div class="col-sm-4">
							<span><spring:message code="modal.acceso.nombre"/>:</span>
						</div>
						<div class="col-sm-8">
							<input type="text" id="mod_acceso_nombre" name="mod_acceso_nombre" class="form-control">
						</div>
					</div>
					<div class="row linea">
						<div class="col-sm-4"></div>
						<div class="col-sm-8">
							<small id="mod_acceso_clave_ayuda" class="text-danger hidden"><spring:message code="formulario.campo.obligatorio"/></small>
						</div>
					</div>
					<div class="row linea">
						<div class="col-sm-4">
							<span><spring:message code="modal.acceso.clave"/>:</span>
						</div>
						<div class="col-sm-8">
							<input type="text" id="mod_acceso_clave" name="mod_acceso_clave" class="form-control">
						</div>
					</div>
					
					<div class="row linea">
						<div class="pull-right">
							<button id="mod_acceso_cancelar" type="button" class="btn btn-danger"><spring:message code="formulario.boton.cancelar"/></button>
							<button id="mod_acceso_sin_credenciales" type="button" class="btn btn-info"><spring:message code="modal.acceso.sin.credenciales"/></button>
							<button id="mod_acceso_con_credenciales" type="button" class="btn btn-success"><spring:message code="formulario.boton.aceptar"/></button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>