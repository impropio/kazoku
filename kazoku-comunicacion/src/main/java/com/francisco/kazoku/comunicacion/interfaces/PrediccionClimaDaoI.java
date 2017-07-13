package com.francisco.kazoku.comunicacion.interfaces;

import com.francisco.kazoku.comunicacion.dto.CiudadClima;

/**
 * 
 * @author Francisco Moro
 *
 */
public interface PrediccionClimaDaoI {
    
    /**
     * 
     * @return datos de la ciudad con la predicción actual
     */
    CiudadClima getPrediccionActual();
    
    /**
     * 
     * @return datos de la ciudad con la predicción para los próximos dias
     */
    CiudadClima getPredicciones();
    
    /**
     * 
     * @param ciudadNombre
     * @param limite
     * @param unidades
     * @param apiId
     * @return
     */
    CiudadClima getPrediccionesNombreCiudad(String ciudadNombre, String limite, String unidades, String apiId);
    
}
