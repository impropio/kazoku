$(document).ready(function(){
	ModalAcceso.iniciar();
});

ModalAcceso = {
		iniciar : function(){
			$('#mod_acceso_cancelar').on('click', function(){
				$('#modal_acceso').modal('hide');
			});
			$('#mod_acceso_sin_credenciales').on('click', function(){
				ModalAcceso.vaciarFormulario();
				ModalAcceso.enviarFormulario();
			});
			$('#mod_acceso_con_credenciales').on('click', function(){
				ModalAcceso.comprobarFormulario();
				ModalAcceso.enviarFormulario();
			});
		},
		
		vaciarFormulario : function(){
			$('#mod_acceso_id_usuario').val("");
			$('#mod_acceso_nombre').val("");
			$('#mod_acceso_clave').val("");
			$('.text-danger').addClass('hidden');
		},
		
		comprobarFormulario : function(){
			var error = false;
			if("" == $('#mod_acceso_nombre').val()){
				$('#mod_acceso_usuario_ayuda').removeClass('hidden');
				error = true;
			}
			if("" == $('#mod_acceso_clave').val()){
				$('#mod_acceso_clave_ayuda').removeClass('hidden');
				error = true;
			}
			if(!error){
				ModalAcceso.enviarFormulario();
			}
		},
		
		enviarFormulario : function(){
			$('#formulario_acceso').submit();
		}
}
