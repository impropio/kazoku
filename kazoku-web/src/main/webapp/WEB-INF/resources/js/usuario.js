$(document).ready(function(){
	$('.info_clave').on('hover click', function(){
		$('.info_clave').notify(diccionario.avisoContrasena, {position:'top-center',className: 'informacion'});
	});
	$('input[name="usa-clave"]').change(function(){
		if(this.checked){
			$('#clave').prop('disabled', false);
			$('#clave2').prop('disabled', false);
		}else{
			$('#clave').val("");
			$('#clave').prop('disabled', true);
			$('#clave2').val("");
			$('#clave2').prop('disabled', true);
		}
	});
	$('#limpiar-formulario').on('click', function(){
		limpiarFormulario();
	});
});

function limpiarFormulario(){
	$('#id_usuario').val('');
	$('#nombre').val('');
	$('input[name="usa-clave"]').prop('checked', false);
	$('#clave').val("");
	$('#clave').prop('disabled', true);
	$('#clave2').val("");
	$('#clave2').prop('disabled', true);
	$('#nacimiento').val('');
	$('#dni').val('');
	$('#pasaporte').val('');
	$('#segsocial').val('');
	$('#gruposanguineo option[value="-"]').prop('selected', true);
	$('#alergias').val('');
	$('#cod_alergias').val('');
}
