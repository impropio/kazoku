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
    public CiudadClimaDto getPrediccionActual() {
        CiudadClimaDto ciudadDto = new CiudadClimaDto();
        CiudadClima ciudad = prediccionDao.getPrediccionActual();
        return ciudadDto.objectToDto(ciudad);
    }
    
    @Override
    public CiudadClimaDto getPredicciones() {
        CiudadClimaDto ciudadDto = new CiudadClimaDto();
        CiudadClima ciudad = prediccionDao.getPredicciones();
        return ciudadDto.objectToDto(ciudad);
    }
    
}
