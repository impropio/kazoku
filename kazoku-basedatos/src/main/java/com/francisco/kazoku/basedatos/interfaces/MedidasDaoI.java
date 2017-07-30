package com.francisco.kazoku.basedatos.interfaces;

import java.util.List;

import com.francisco.kazoku.basedatos.core.interfaces.AbstractDaoI;
import com.francisco.kazoku.basedatos.entities.Medidas;

public interface MedidasDaoI extends AbstractDaoI<Medidas>{
    
    List<Medidas> getMedidasIdioma(String idioma);
    
}
