$(document).ready(function(){
	$('.mod_usu_info_clave').on('hover click', function(){
		$('.mod_usu_info_clave').notify(diccionario.avisoContrasena, {position:'top-center',className: 'informacion'});
	});
	$('input[name="mod_usu_usa-clave"]').change(function(){
		if(this.checked){
			$('#mod_usu_clave').prop('disabled', false);
			$('#mod_usu_clave2').prop('disabled', false);
		}else{
			$('#mod_usu_clave').val("");
			$('#mod_usu_clave').prop('disabled', true);
			$('#mod_usu_clave2').val("");
			$('#mod_usu_clave2').prop('disabled', true);
		}
	});
	$('#mod_usu_limpiar_formulario').on('click', function(){
		limpiarFormulario();
	});
	$('#mod_usu_actualizar_usuario').on('click', function(){
		enviarFormulario();
	});
});

function limpiarFormulario(){
	$('#mod_usu_id_usuario').val('');
	$('#mod_usu_nombre').val('');
	$('input[name="mod_usu_usa-clave"]').prop('checked', false);
	$('#mod_usu_clave').val("");
	$('#mod_usu_clave').prop('disabled', true);
	$('#mod_usu_clave2').val("");
	$('#mod_usu_clave2').prop('disabled', true);
	$('#mod_usu_nacimiento').val('');
	$('#mod_usu_dni').val('');
	$('#mod_usu_pasaporte').val('');
	$('#mod_usu_segsocial').val('');
	$('#mod_usu_gruposanguineo option[value="-"]').prop('selected', true);
	$('#mod_usu_alergias').val('');
	$('#mod_usu_cod_alergias').val('');
}

function enviarFormulario(){
	if($('#mod_usu_nombre').val() == ""){
		$('#mod_usu_nombre').notify(diccionario.campoObligatorio, {position:'top-center',className: 'error'});
		return;
	}
	if($('input[name="mod_usu_usa-clave"]').is(":checked")){
		if($('#mod_usu_clave').val() == ""){
			$('#mod_usu_clave').notify(diccionario.campoObligatorio, {position:'top-center',className: 'error'});
			return;
		}else{
			if($('#mod_usu_clave').val() != $('#mod_usu_clave2').val()){
				$('#mod_usu_clave2').notify(diccionario.errorRepetirClave, {position:'top-center',className: 'error'});
				return;
			}
		}
	}
	
	$.ajax({
		url: diccionario.pageContext+"/usuario/actualizar",
		type: "POST",
		data: {
			id: $('#mod_usu_id_usuario').val(),
			nombre: $('#mod_usu_nombre').val(),
			clave: $('#mod_usu_clave').val(),
			nacimiento: $('#mod_usu_nacimiento').val(),
			dni: $('#mod_usu_dni').val(),
			pasaporte: $('#mod_usu_pasaporte').val(),
			segSocial: $('#mod_usu_segsocial').val(),
			grupoSanguineo: $('#mod_usu_gruposanguineo').val(),
			codigosAlergias: $('#mod_usu_cod_alergias').val()
		}
	}).success(function(){
		$.notify(diccionario.formularioDatosGrabados);
	}).error(function(){
		$.notify(diccionario.formularioErrorDatosGrabados, 'error');
	});
}
