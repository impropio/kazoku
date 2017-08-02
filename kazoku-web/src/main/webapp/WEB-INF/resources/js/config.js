$(document).ready(function(){
	$('#ciudad').on('keyup', function(){
		cargarCiudades();
	});
});

function cargarCiudades(){
	if($('#ciudad').val().length > 2){
		$.ajax({url:"localhost:8080/kazoku/configuracion/ciudadespais"}).done(function(data){
			for(var i=0; i<data.length; i++){
				$('lista-ciudades').append('<option data-valor="1" value="'+i+'"/>');
			}
		});
	}
}
