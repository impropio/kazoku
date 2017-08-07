$(document).ready(function(){
	anchoPredicciones();
});

function anchoPredicciones(){
	var numeroPredicciones = $('.predicciones').length;
	var porc = 100 / numeroPredicciones - 1;
	$('.predicciones').css('width', porc+"%");
}