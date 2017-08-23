package com.francisco.kazoku.servicios.interfaces;

import com.francisco.kazoku.servicios.dto.CiudadClimaDto;

/**
 * 
 * @author Francisco Moro <jfmoro@gmail.com>
 * @since 0.1
 *
 */
public interface PrediccionClimaServiceI {
    
    /**
     * 
     * @param idCiudad
     * @param unidades
     * @param apiId
     * @return datos de la ciudad con la predicción actual
     */
    CiudadClimaDto getPrediccionActual(String idCiudad, String unidades, String apiId);
    
    /**
     * 
     * @param idCiudad
     * @param unidades
     * @param apiId
     * @param numeroDias
     * @return datos de la ciudad con la predicción para los próximos dias
     */
    CiudadClimaDto getPredicciones(String idCiudad, String unidades, String apiId, Integer numeroDias);
    
}
