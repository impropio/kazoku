package com.francisco.kazoku.basedatos.interfaces;

import com.francisco.kazoku.basedatos.core.interfaces.AbstractDaoI;
import com.francisco.kazoku.basedatos.entities.Alergia;

/**
 * 
 * @author Francisco Moro <jfmoro@gmail.com>
 * @since 0.1
 *
 */
public interface AlergiaDaoI extends AbstractDaoI<Alergia>{
    
    /**
     * Recupera una alergia por su id
     * 
     * @param id
     * @return Alergia
     */
    Alergia getAlergiaById(Integer id);
    
}
