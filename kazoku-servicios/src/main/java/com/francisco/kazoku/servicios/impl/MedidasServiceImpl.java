package com.francisco.kazoku.servicios.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.francisco.kazoku.basedatos.entities.Medidas;
import com.francisco.kazoku.basedatos.interfaces.MedidasDaoI;
import com.francisco.kazoku.servicios.dto.MedidasDto;
import com.francisco.kazoku.servicios.interfaces.MedidasServiceI;

@Service
public class MedidasServiceImpl implements MedidasServiceI{

    @Autowired
    private MedidasDaoI medidasDao;
    
    @Override
    public List<MedidasDto> getMedidas(String idioma){
        List<MedidasDto> medidasDto = new ArrayList<MedidasDto>();
        List<Medidas> medidas = medidasDao.getMedidasIdioma(idioma);
        
        for(Medidas medida : medidas){
            MedidasDto medidaDto = new MedidasDto();
            medidasDto.add(medidaDto.entityToDto(medida));
        }
        
        return medidasDto;
    }
    
}
