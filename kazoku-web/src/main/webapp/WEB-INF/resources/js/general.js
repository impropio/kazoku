$(document).ready(function(){
	$('.range .selector').each(function(){
		controlRango($(this));
	});
	$('.range .selector').on('input', function(){
		controlRango($(this));
	});
});

function controlRango($campo){
	var valor = $campo.val();
	var max = $campo.attr('max');
	var min = $campo.attr('min');
	var anchoBarra = $campo.width();
	var anchoSpan = anchoBarra/5;
	var progreso = (valor-min) * (anchoBarra/(max-min)-(anchoSpan/(max-min)))+15;
	var porc = (valor-min) * 100 / (max-min);
	$campo.siblings('.valor')
		.text(valor)
		.css('left', progreso + 'px');
	$($campo)
		.css('background-image','-webkit-gradient(linear, left top, right top, color-stop('+porc+'%, #999999), color-stop('+porc+'%, #DDDDDD))');
	$($campo).css('background-image', '-moz-linear-gradient(left center, #999999 0%, #999999 '+porc+'%, #DDDDDD '+porc+'%, #DDDDDD 100%)');
}