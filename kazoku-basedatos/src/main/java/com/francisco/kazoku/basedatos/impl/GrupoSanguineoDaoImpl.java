package com.francisco.kazoku.basedatos.impl;

import org.springframework.stereotype.Repository;

import com.francisco.kazoku.basedatos.core.impl.AbstractDao;
import com.francisco.kazoku.basedatos.entities.GrupoSanguineo;
import com.francisco.kazoku.basedatos.interfaces.GrupoSanguineoDaoI;

/**
 * 
 * @author Francisco Moro
 * @since 01/08/2017
 * @version 0.1
 *
 */
@Repository
public class GrupoSanguineoDaoImpl extends AbstractDao<GrupoSanguineo> implements GrupoSanguineoDaoI{

    /**
     * Recupera la clase del objeto
     */
    @Override
    public Class<GrupoSanguineo> getClase(){
        return GrupoSanguineo.class;
    }
    
}
