$(document).ready(function(){
	$('[data-toggle="popover"]').popover();
	$('.nombre-usuario').on('click', function(){
		var id = $(this).attr('data-idUsuario');
		$('#mod_acceso_id_usuario').val(id);
		$('#formulario_acceso').attr('action', $('#formulario_acceso').attr('action') + "usuario/acceso")
		$('#modal_acceso').modal('show');
	})
});




