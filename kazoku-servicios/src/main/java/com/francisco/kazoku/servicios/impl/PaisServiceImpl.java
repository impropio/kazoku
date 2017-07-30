package com.francisco.kazoku.servicios.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.francisco.kazoku.basedatos.entities.Pais;
import com.francisco.kazoku.basedatos.interfaces.PaisDaoI;
import com.francisco.kazoku.servicios.dto.PaisDto;
import com.francisco.kazoku.servicios.interfaces.PaisServiceI;

@Service
public class PaisServiceImpl implements PaisServiceI{

    @Autowired
    private PaisDaoI paisDao;
    
    @Override
    public List<PaisDto> getPaises(String idioma){
        List<PaisDto> paisesDto = new ArrayList<PaisDto>();
        List<Pais> paises = paisDao.getPaises(idioma);
        
        for(Pais pais : paises){
            PaisDto paisDto = new PaisDto();
            paisesDto.add(paisDto.entityToDto(pais));
        }
        
        return paisesDto;
    }

    @Override
    public PaisDto getPaiseById(String idioma, String codPais){
        PaisDto paisDto = new PaisDto();
        
        Pais pais = paisDao.getPaisById(idioma, codPais);
        paisDto = paisDto.entityToDto(pais);
        
        return paisDto;
    }
    
}
