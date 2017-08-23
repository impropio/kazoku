package com.francisco.kazoku.basedatos.interfaces;

import java.util.List;

import com.francisco.kazoku.basedatos.core.interfaces.AbstractDaoI;
import com.francisco.kazoku.basedatos.entities.Ciudad;

/**
 * 
 * @author Francisco Moro <jfmoro@gmail.com>
 * @since 0.1
 *
 */
public interface CiudadDaoI extends AbstractDaoI<Ciudad>{
    
    /**
     * Recupera una ciudad de la base de datos por su id
     * 
     * @param idCiudad
     * @return ciudad
     */
    Ciudad getCiudadById(Integer idCiudad);
    
    /**
     * Recupera un numero establecido de ciudades por el codigo de pais y el comienzo de sus palabras
     * 
     * @param codPais
     * @param texto
     * @param limite
     * @return lista de ciudades que cumplan con los requisitos
     */
    List<Ciudad> getCiudadesPaisTextoLimite(String codPais, String texto, Integer limite);
    
}
