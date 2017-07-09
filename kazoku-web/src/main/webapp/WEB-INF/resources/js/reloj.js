$(function(){
	
	// Selectores
    var reloj = $('#reloj');
    var alarm = reloj.find('.alarm');
    var ampm = reloj.find('.ampm');

    // Nombre de los dígitos
    var digitosANombre = 'cero uno dos tres cuatro cinco seis siete ocho nueve'.split(' ');

    // Array que contendrá los dígitos
    var digitos = {};

    // Posición para las horas, minutos y segundos
    var posiciones = [
        'h1', 'h2', ':', 'm1', 'm2', ':', 's1', 's2'
    ];

    // Elemento contenedor de los dígitos
    var contenedorDigitos = reloj.find('.digitos');

    $.each(posiciones, function(){
        if(this == ':'){
            contenedorDigitos.append('<div class="separador">');
        }
        else{
            var pos = $('<div>');
            for(var i=1; i<8; i++){
                pos.append('<span class="d' + i + '">');
            }

            // Setea los dígitos como pares de key:value
            digitos[this] = pos;

            // Añade el elemento dígitos a la página
            contenedorDigitos.append(pos);
        }
    });

    // Añade los días de la semana
    var diaSemenaNombres = diccionario.diaSemanaNombres.split(' ');debugger;
    var diaSemenaContenedor = reloj.find('.diasSemana');
    var mesNombres = diccionario.mesNombres.split(' ');
    var fechaContenedor = reloj.find('.fecha')

    $.each(diaSemenaNombres, function(){
        diaSemenaContenedor.append('<span>' + this + '</span>');
    });

    var diasSemana = reloj.find('.diasSemana span');

    // Función para actualizar el reloj cada segundo
    (function actualizarHora(){

        // Utiliza el fichero moment.js para mostrar la hora actual como texto
        // hh para las horas en formato 12 horas,
    	// HH para las horas en formato 24 horas,
        // mm - minutos, ss-segundos,
        // d para el día de la semana y A para AM/PM
//        var ahora = moment().format("hhmmssdA");
    	var ahora = moment().format("HHmmssdA");

        digitos.h1.attr('class', digitosANombre[ahora[0]]);
        digitos.h2.attr('class', digitosANombre[ahora[1]]);
        digitos.m1.attr('class', digitosANombre[ahora[2]]);
        digitos.m2.attr('class', digitosANombre[ahora[3]]);
        digitos.s1.attr('class', digitosANombre[ahora[4]]);
        digitos.s2.attr('class', digitosANombre[ahora[5]]);

        // La libreria devuelve el Domingo como primer día de la semana
        // se mueven todos los dias una posición para convertir el Domingo
        // en el último día
        var bajar = ahora[6];
        bajar--;

        // Domingo
        if(bajar < 0){
            // Se convierte en el último día
            bajar = 6;
        }

     // Resaltar el día actual, si es domingo se resalta en rojo
        if(bajar != 6){
	        diasSemana.removeClass('active').eq(bajar).addClass('active');
        }else{
        	diasSemana.removeClass('active').eq(bajar).addClass('active festivo');
        }
        
        // Escribir fecha
        var f=new Date();
        fechaContenedor.html(
        		"<h3>" +
        		f.getDate() + " " + 
        		diccionario.separadorFecha.split(' ')[0] + " " + 
        		mesNombres[f.getMonth()] + " " + 
        		diccionario.separadorFecha.split(' ')[1] + " " + 
        		f.getFullYear() +
        		"</h3>");

        // Escribir el texto am/pm
        ampm.text(ahora[7]+ahora[8]);

        // Ejecutar esta funcion cada segundo
        setTimeout(actualizarHora, 1000);

    })();

    // Cambiar el tema del reloj
    $('a.button').click(function(){
        reloj.toggleClass('light dark');
    });

});
