package com.francisco.kazoku.servicios.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.francisco.kazoku.basedatos.entities.GrupoSanguineo;
import com.francisco.kazoku.basedatos.interfaces.GrupoSanguineoDaoI;
import com.francisco.kazoku.servicios.dto.GrupoSanguineoDto;
import com.francisco.kazoku.servicios.interfaces.GrupoSanguineoServiceI;

@Service
public class GrupoSanguineoServiceImpl implements GrupoSanguineoServiceI{

    @Autowired
    GrupoSanguineoDaoI grupoSanguineoDao;
    
    @Override
    public List<GrupoSanguineoDto> getGruposSanguineos(){
        List<GrupoSanguineoDto> listaGruposDto = new ArrayList<GrupoSanguineoDto>();
        List<GrupoSanguineo> listaGrupos = grupoSanguineoDao.getAll();
        
        for(GrupoSanguineo grupo : listaGrupos){
            GrupoSanguineoDto grupoDto = new GrupoSanguineoDto();
            listaGruposDto.add(grupoDto.entityToDto(grupo));
        }
        
        return listaGruposDto;
    }
    
}
