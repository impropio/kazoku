package com.francisco.kazoku.comunicacion.interfaces;

import com.francisco.kazoku.comunicacion.dto.CiudadClima;

/**
 * 
 * @author Francisco Moro
 *
 */
public interface PrediccionClimaI {
    
    /**
     * 
     * @return datos de la ciudad con la predicción para los próximos dias
     */
    CiudadClima getPredicciones();
}
