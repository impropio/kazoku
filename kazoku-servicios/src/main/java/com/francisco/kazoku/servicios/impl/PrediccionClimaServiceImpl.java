package com.francisco.kazoku.servicios.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.francisco.kazoku.comunicacion.dto.CiudadClima;
import com.francisco.kazoku.comunicacion.interfaces.PrediccionClimaDaoI;
import com.francisco.kazoku.servicios.dto.CiudadClimaDto;
import com.francisco.kazoku.servicios.interfaces.PrediccionClimaServiceI;

/**
 * 
 * @author Francisco Moro <jfmoro@gmail.com>
 * @since 0.1
 *
 */
@Service
public class PrediccionClimaServiceImpl implements PrediccionClimaServiceI{

    @Autowired
    PrediccionClimaDaoI prediccionDao;
    
    /**
     * Recupera la predicción del clima para hoy para la ciudad seleccionada
     * 
     * @param idCiudad
     * @param unidades
     * @param apiId -> id del usuario en el sistema openweathermap
     * @return ciudadDto -> objeto ciudad con los parámetros del clima
     */
    @Override
    public CiudadClimaDto getPrediccionActual(String idCiudad, String unidades, String apiId) {
        CiudadClimaDto ciudadDto = new CiudadClimaDto();
        CiudadClima ciudad = prediccionDao.getPrediccionActual(idCiudad, unidades, apiId);
        return ciudadDto.objectToDto(ciudad);
    }
    
    /**
     * Recupera la predicción del tiempo para el número de dias y la ciudad seleccionados
     * 
     * @param idCiudad
     * @param unidades
     * @param apiId -> id del usuario en el sistema openweathermap
     * @param numeroDias
     * @return ciudadDto -> objeto ciudad con los parámetros del clima
     */
    @Override
    public CiudadClimaDto getPredicciones(String idCiudad, String unidades, String apiId, Integer numeroDias) {
        CiudadClimaDto ciudadDto = new CiudadClimaDto();
        CiudadClima ciudad = prediccionDao.getPredicciones(idCiudad, unidades, apiId, numeroDias);
        return ciudadDto.objectToDto(ciudad);
    }
    
}
