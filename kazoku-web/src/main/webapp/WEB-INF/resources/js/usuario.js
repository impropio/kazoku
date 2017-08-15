$(document).ready(function(){
	$('.info_clave').on('hover click', function(){
		$('.info_clave').notify(diccionario.avisoContrasena, {position:'top-center',className: 'informacion'});
	});
});
