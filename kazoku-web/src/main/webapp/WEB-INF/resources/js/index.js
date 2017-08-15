$(document).ready(function(){
	anchoPredicciones();
	$('.modo-noche').on('click', function(){
		modoNoche($(this));
	});
});

function anchoPredicciones(){
	var numeroPredicciones = $('.predicciones').length;
	var porc = 100 / numeroPredicciones - 1;
	$('.predicciones').css('width', porc+"%");
}

function modoNoche($control){
	if($control.hasClass('activa')){
		$control.removeClass('activa');
		$.notify(diccionario.modoNocheDesactivado, 'informacion');
	}else{
		$control.addClass('activa');
		$.notify(diccionario.modoNocheActivado, 'informacion');
	}
}
