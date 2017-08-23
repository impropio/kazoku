package com.francisco.kazoku.basedatos.interfaces;

import java.util.List;

import com.francisco.kazoku.basedatos.core.interfaces.AbstractDaoI;
import com.francisco.kazoku.basedatos.entities.Pais;

/**
 * 
 * @author Francisco Moro <jfmoro@gmail.com>
 * @since 0.1
 *
 */
public interface PaisDaoI extends AbstractDaoI<Pais>{
    
    /**
     * Recupera la lista de paises en el idioma del usuario
     * 
     * @param idioma
     * @return lista de paises
     */
    List<Pais> getPaises(String idioma);
    
    /**
     * Recupera la información de un país por su id en el idioma del usuario
     * 
     * @param idioma
     * @param codPais
     * @return pais
     */
    Pais getPaisById(String idioma, String codPais);
}
