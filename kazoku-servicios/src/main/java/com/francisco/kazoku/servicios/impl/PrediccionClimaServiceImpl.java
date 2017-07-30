package com.francisco.kazoku.servicios.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.francisco.kazoku.comunicacion.dto.CiudadClima;
import com.francisco.kazoku.comunicacion.interfaces.PrediccionClimaDaoI;
import com.francisco.kazoku.servicios.dto.CiudadClimaDto;
import com.francisco.kazoku.servicios.interfaces.PrediccionClimaServiceI;

@Service
public class PrediccionClimaServiceImpl implements PrediccionClimaServiceI{

    @Autowired
    PrediccionClimaDaoI prediccionDao;
    
    @Override
    public CiudadClimaDto getPrediccionActual(String idCiudad, String unidades, String apiId) {
        CiudadClimaDto ciudadDto = new CiudadClimaDto();
        CiudadClima ciudad = prediccionDao.getPrediccionActual(idCiudad, unidades, apiId);
        return ciudadDto.objectToDto(ciudad);
    }
    
    @Override
    public CiudadClimaDto getPredicciones(String idCiudad, String unidades, String apiId, Integer numeroDias) {
        CiudadClimaDto ciudadDto = new CiudadClimaDto();
        CiudadClima ciudad = prediccionDao.getPredicciones(idCiudad, unidades, apiId, numeroDias);
        return ciudadDto.objectToDto(ciudad);
    }
    
}
