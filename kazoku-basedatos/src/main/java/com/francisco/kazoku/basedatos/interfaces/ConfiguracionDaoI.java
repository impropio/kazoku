package com.francisco.kazoku.basedatos.interfaces;

import com.francisco.kazoku.basedatos.core.interfaces.AbstractDaoI;
import com.francisco.kazoku.basedatos.entities.Configuracion;

public interface ConfiguracionDaoI extends AbstractDaoI<Configuracion>{
    
    Configuracion getConfiguracion();
}
