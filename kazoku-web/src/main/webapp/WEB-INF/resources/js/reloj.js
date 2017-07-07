$(function(){
	
	// Selectores
    var reloj = $('#reloj');
    var alarm = reloj.find('.alarm');
    var ampm = reloj.find('.ampm');

    // Map digitos to their names (this will be an array)
    var digitosANombre = 'cero uno dos tres cuatro cinco seis siete ocho nueve'.split(' ');

    // This object will hold the digit elements
    var digitos = {};

    // posiciones for the hours, minutes, and seconds
    var posiciones = [
        'h1', 'h2', ':', 'm1', 'm2', ':', 's1', 's2'
    ];

    // Generate the digitos with the needed markup,
    // and add them to the reloj

    var contenedorDigitos = reloj.find('.digitos');

    $.each(posiciones, function(){

        if(this == ':'){
            contenedorDigitos.append('<div class="dots">');
        }
        else{

            var pos = $('<div>');

            for(var i=1; i<8; i++){
                pos.append('<span class="d' + i + '">');
            }

            // Set the digitos as key:value pairs in the digitos object
            digitos[this] = pos;

            // Add the digit elements to the page
            contenedorDigitos.append(pos);
        }

    });

    // Add the weekday names

    var diaSemenaNombres = 'LUN MAR MIER JUE VIE SAB DOM'.split(' '),
        diaSemenaContenedor = reloj.find('.diasSemana');

    $.each(diaSemenaNombres, function(){
        diaSemenaContenedor.append('<span>' + this + '</span>');
    });

    var diasSemana = reloj.find('.diasSemana span');

    // Run a timer every second and update the reloj

    (function actualizarHora(){

        // Use moment.js to output the current time as a string
        // hh is for the hours in 12-hour format,
        // mm - minutes, ss-seconds (all with leading ceros),
        // d is for day of week and A is for AM/PM

//        var ahora = moment().format("hhmmssdA");
    	var ahora = moment().format("HHmmssdA");

        digitos.h1.attr('class', digitosANombre[ahora[0]]);
        digitos.h2.attr('class', digitosANombre[ahora[1]]);
        digitos.m1.attr('class', digitosANombre[ahora[2]]);
        digitos.m2.attr('class', digitosANombre[ahora[3]]);
        digitos.s1.attr('class', digitosANombre[ahora[4]]);
        digitos.s2.attr('class', digitosANombre[ahora[5]]);

        // The library returns Sunday as the first day of the week.
        // Stupid, I know. Lets shift all the days uno position down, 
        // and make Sunday last

        var bajar = ahora[6];
        bajar--;

        // Sunday!
        if(bajar < 0){
            // Make it last
            bajar = 6;
        }

        // Mark the active day of the week
        diasSemana.removeClass('active').eq(bajar).addClass('active');

        // Set the am/pm text:
        ampm.text(ahora[7]+ahora[8]);

        // Schedule this function to be run again in 1 sec
        setTimeout(actualizarHora, 1000);

    })();

    // Switch the theme

    $('a.button').click(function(){
        reloj.toggleClass('light dark');
    });

});