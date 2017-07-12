package com.francisco.kazoku.servicios.interfaces;

import com.francisco.kazoku.servicios.dto.CiudadClimaDto;

/**
 * 
 * @author Francisco Moro
 *
 */
public interface PrediccionClimaServiceI {
    
    /**
     * 
     * @return datos de la ciudad con la predicción para los próximos dias
     */
    CiudadClimaDto getPredicciones();
    
}
