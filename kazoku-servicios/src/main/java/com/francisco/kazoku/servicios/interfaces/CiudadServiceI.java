package com.francisco.kazoku.servicios.interfaces;

import java.util.List;

import com.francisco.kazoku.servicios.dto.CiudadDto;

/**
 * 
 * @author Francisco Moro <jfmoro@gmail.com>
 * @since 0.1
 *
 */
public interface CiudadServiceI{
    
    /**
     * Recupera una lista de ciudades de tamaño definido para un país concreto y que el texto coincida con el comienzo
     * de algúna de sus palabras
     *  
     * @param codPais
     * @param texto
     * @param limite
     * @return lista de ciudadDto
     */
    List<CiudadDto> getCiudadesPaisTextoLimite(String codPais, String texto, Integer limite);
    
    /**
     * Recupera una ciudad a traves de su id
     * 
     * @param idCiudad
     * @return ciudadDto
     */
    CiudadDto getCiudadById(Integer idCiudad);
    
}
