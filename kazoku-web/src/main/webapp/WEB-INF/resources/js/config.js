$(document).ready(function(){
	$('#ciudad').on('keyup input', function(){
		cargarCiudades();
		var valor = $('#ciudad').val().toLowerCase();
		$('#ciudad').data('valor', $('#lista-ciudades [data-nombre="'+valor+'"]').data('valor'));
	});
	$('#pais').on('change', function(){
		$('#ciudad').val('');
		if($('#pais').val() == "-"){
			$('#ciudad').attr('disabled', true);
		}else{
			$('#ciudad').attr('disabled', false);
		}
		cargarCiudades();
	});
	$('#actualizar-ubicacion').on('click', function(){
		actualizarUbicacion();
	});
});

function cargarCiudades(){
	var txtCiudad = $('#ciudad').val();
	$.ajax({
		url: diccionario.pageContext+"/configuracion/ciudadespais",
		type: "POST",
		data: {
			pais: $('#pais').val(),
			ciudad: txtCiudad
		}
	}).done(function(data){
		var ciudades = JSON.parse(data);
		$('#lista-ciudades').empty();
		for(var i=0; i<ciudades.length; i++){
			$('#lista-ciudades').append('<option data-valor="'+ciudades[i].idCiudad+'" value="'+ciudades[i].nombreCiudad+'" data-nombre="'+ciudades[i].nombreCiudad.toLowerCase()+'"/>');
		}
	});
}

function actualizarUbicacion(){
	$.ajax({
		url: diccionario.pageContext+"/configuracion/actualizarubicacion",
		type: "POST",
		data: {
			ciudad: $('#ciudad').data('valor'),
			unidades: $('input[name="medidas"]:checked').val(),
			numerodias: $('#dias-prediccion').val(),
			codigoapi: $('#api-clima').val()
		}
	}).success(function(){
		$.notify(diccionario.ubicacionActualizada);
	}).error(function(){
		$.notify(diccionario.ubicacionNoActualizada, 'error');
	});
}
