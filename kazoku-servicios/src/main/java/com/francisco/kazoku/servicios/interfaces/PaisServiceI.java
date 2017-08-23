package com.francisco.kazoku.servicios.interfaces;

import java.util.List;

import com.francisco.kazoku.servicios.dto.PaisDto;

/**
 * 
 * @author Francisco Moro <jfmoro@gmail.com>
 * @since 0.1
 *
 */
public interface PaisServiceI{
    
    /**
     *  Recupera la lista de paises en el idioma del usuario
     *  
     * @param idioma
     * @return lista de PaisDto
     */
    List<PaisDto> getPaises(String idioma);
    
    /**
     * Recupera un país en el idioma del usuario a traves de su id
     * 
     * @param idioma
     * @param codPais
     * @return PaisDto
     */
    PaisDto getPaiseById(String idioma, String codPais);
    
}
