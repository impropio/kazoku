package com.francisco.kazoku.servicios.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.francisco.kazoku.basedatos.entities.Ciudad;
import com.francisco.kazoku.basedatos.interfaces.CiudadDaoI;
import com.francisco.kazoku.servicios.dto.CiudadDto;
import com.francisco.kazoku.servicios.interfaces.CiudadServiceI;

@Service
public class CiudadServiceImpl implements CiudadServiceI{

    @Autowired
    private CiudadDaoI ciudadDao;
    
//    @Override
//    public List<CiudadDto> getCiudadPais(String codPais){
//        List<CiudadDto> ciudadesDto = new ArrayList<CiudadDto>();
//        List<Ciudad> ciudades = ciudadDao.getCiudadesPais(codPais);
//        
//        for(Ciudad ciudad : ciudades){
//            CiudadDto ciudadDto = new CiudadDto();
//            ciudadesDto.add(ciudadDto.entityToDto(ciudad));
//        }
//        
//        return ciudadesDto;
//    }

    @Override
    public CiudadDto getCiudadById(Integer idCiudad){
        CiudadDto ciudadDto = new CiudadDto();
        
        Ciudad ciudad = ciudadDao.getCiudadById(idCiudad);
        ciudadDto = ciudadDto.entityToDto(ciudad);
        
        return ciudadDto;
    }

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
