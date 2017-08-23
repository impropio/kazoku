package com.francisco.kazoku.servicios.interfaces;

import java.util.List;

import com.francisco.kazoku.servicios.dto.MedidasDto;

/**
 * 
 * @author Francisco Moro <jfmoro@gmail.com>
 * @since 0.1
 *
 */
public interface MedidasServiceI{
    
    /**
     * Recupera la lista de sistemas de medida disponibles en el idioma del usuario
     * 
     * @param idioma
     * @return lista de MedidasDto
     */
    List<MedidasDto> getMedidas(String idioma);
    
}
