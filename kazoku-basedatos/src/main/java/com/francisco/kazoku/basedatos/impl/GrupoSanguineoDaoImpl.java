package com.francisco.kazoku.basedatos.impl;

import org.springframework.stereotype.Repository;

import com.francisco.kazoku.basedatos.core.impl.AbstractDao;
import com.francisco.kazoku.basedatos.entities.GrupoSanguineo;
import com.francisco.kazoku.basedatos.interfaces.GrupoSanguineoDaoI;

@Repository
public class GrupoSanguineoDaoImpl extends AbstractDao<GrupoSanguineo> implements GrupoSanguineoDaoI{

    @Override
    public Class<GrupoSanguineo> getClase(){
        return GrupoSanguineo.class;
    }
    
}
