package com.francisco.kazoku.basedatos.interfaces;

import java.util.List;

import com.francisco.kazoku.basedatos.core.interfaces.AbstractDaoI;
import com.francisco.kazoku.basedatos.entities.Medidas;

/**
 * 
 * @author Francisco Moro <jfmoro@gmail.com>
 * @since 0.1
 *
 */
public interface MedidasDaoI extends AbstractDaoI<Medidas>{
    
    /**
     * Recupera la lista de sistemas de medición en el idioma del usuario
     * 
     * @param idioma
     * @return lista de medidas
     */
    List<Medidas> getMedidasIdioma(String idioma);
    
    /**
     * Recupera un sistema de medidas por su id
     * 
     * @param id
     * @return medida
     */
    Medidas getMedidasById(Integer id);
    
}
