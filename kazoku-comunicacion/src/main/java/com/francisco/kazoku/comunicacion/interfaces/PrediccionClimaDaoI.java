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
     * @param idCiudad
     * @param unidades
     * @param apiId
     * @return datos de la ciudad con la predicción actual
     */
    CiudadClima getPrediccionActual(String idCiudad, String unidades, String apiId);
    
    /**
     * 
     * @param idCiudad
     * @param unidades
     * @param apiId
     * @param numeroDias
     * @return datos de la ciudad con la predicción para los próximos dias
     */
    CiudadClima getPredicciones(String idCiudad, String unidades, String apiId, Integer numeroDias);
    
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
