package com.francisco.kazoku.basedatos.interfaces;

import java.util.List;

import com.francisco.kazoku.basedatos.core.interfaces.AbstractDaoI;
import com.francisco.kazoku.basedatos.entities.Pais;

public interface PaisDaoI extends AbstractDaoI<Pais>{
    
    List<Pais> getPaises(String idioma);
    
    Pais getPaisById(String idioma, String codPais);
}
