$(document).ready(function(){
	$('#ciudad').on('keyup', function(){
		cargarCiudades();
	});
});

function cargarCiudades(){
	var txtCiudad = $('#ciudad').val();
	if(txtCiudad.length > 2){
		$.ajax({
			url: "http://localhost:8080/kazoku-web/configuracion/ciudadespais",
			type: "POST",
			data: {
				pais: $('#pais').val(),
				ciudad: txtCiudad
			}
		}).done(function(data){
			var ciudades = JSON.parse(data);
			$('#lista-ciudades').empty();
			for(var i=0; i<ciudades.length; i++){
				$('#lista-ciudades').append('<option data-valor="'+ciudades[i].idCiudad+'" value="'+ciudades[i].nombreCiudad+'"/>');
			}
		});
	}
}
