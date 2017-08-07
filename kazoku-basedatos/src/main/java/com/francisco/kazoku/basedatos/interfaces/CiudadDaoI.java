package com.francisco.kazoku.basedatos.interfaces;

import java.util.List;

import com.francisco.kazoku.basedatos.core.interfaces.AbstractDaoI;
import com.francisco.kazoku.basedatos.entities.Ciudad;

public interface CiudadDaoI extends AbstractDaoI<Ciudad>{
    
    Ciudad getCiudadById(Integer idCiudad);
    
//    List<Ciudad> getCiudadesPais(String codPais);
    
    List<Ciudad> getCiudadesPaisTextoLimite(String codPais, String texto, Integer limite);
    
}
