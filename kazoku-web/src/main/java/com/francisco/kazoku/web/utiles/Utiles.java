package com.francisco.kazoku.web.utiles;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * @author Francisco Moro <jfmoro@gmail.com>
 * @since 0.1
 *
 */
public class Utiles {
    
    /**
     * Formatea una fecha para mostrarla en pantalla
     * 
     * @param fecha
     * @param formato
     * @return fecha en formato de texto
     */
    public static String fechaCorta(Date fecha, String formato){
        SimpleDateFormat sdf = new SimpleDateFormat(formato);
        return sdf.format(fecha);
    }
    
}
