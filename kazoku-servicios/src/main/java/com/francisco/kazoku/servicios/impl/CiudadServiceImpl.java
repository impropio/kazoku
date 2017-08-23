package com.francisco.kazoku.servicios.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.francisco.kazoku.basedatos.entities.Ciudad;
import com.francisco.kazoku.basedatos.interfaces.CiudadDaoI;
import com.francisco.kazoku.servicios.dto.CiudadDto;
import com.francisco.kazoku.servicios.interfaces.CiudadServiceI;

/**
 * 
 * @author Francisco Moro <jfmoro@gmail.com>
 * @since 0.1
 *
 */
@Service
public class CiudadServiceImpl implements CiudadServiceI{

    @Autowired
    private CiudadDaoI ciudadDao;

    /**
     * Recupera una ciudad por si id
     * 
     * @param idCiudad
     * @return ciudadDto
     */
    @Override
    public CiudadDto getCiudadById(Integer idCiudad){
        CiudadDto ciudadDto = new CiudadDto();
        
        Ciudad ciudad = ciudadDao.getCiudadById(idCiudad);
        ciudadDto = ciudadDto.entityToDto(ciudad);
        
        return ciudadDto;
    }

    /**
     * Recupera una lista de ciudades del tamaño indicado, basandose en el codigo de país y el comienzo de sus palabras
     * 
     * @param codPais
     * @param texto
     * @param limite
     * @return ciudadesDto -> lista de ciudades que cumplen los requisitos
     */
    @Override
    public List<CiudadDto> getCiudadesPaisTextoLimite(String codPais, String texto, Integer limite){
        List<CiudadDto> ciudadesDto = new ArrayList<CiudadDto>();
        List<Ciudad> ciudades = ciudadDao.getCiudadesPaisTextoLimite(codPais, texto, limite);
        
        for(Ciudad ciudad : ciudades){
            CiudadDto ciudadDto = new CiudadDto();
            ciudadesDto.add(ciudadDto.entityToDto(ciudad));
        }
        
        return ciudadesDto;
    }
    
}
