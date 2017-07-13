package com.francisco.kazoku.web.utiles;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utiles {
    
    public static String fechaCorta(Date fecha, String formato){
        SimpleDateFormat sdf = new SimpleDateFormat(formato);
        return sdf.format(fecha);
    }
    
}
