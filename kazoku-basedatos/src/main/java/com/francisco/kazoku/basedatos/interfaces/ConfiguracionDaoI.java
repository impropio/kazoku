package com.francisco.kazoku.basedatos.interfaces;

import com.francisco.kazoku.basedatos.core.interfaces.AbstractDaoI;
import com.francisco.kazoku.basedatos.entities.Configuracion;

/**
 * 
 * @author Francisco Moro <jfmoro@gmail.com>
 * @since 0.1
 *
 */
public interface ConfiguracionDaoI extends AbstractDaoI<Configuracion>{
    
    /**
     * Recupera la información de la configuración básica
     * 
     * @return configuracion
     */
    Configuracion getConfiguracion();
    
    /**
     * Actualiza la configuración básica
     * 
     * @param conf
     * @return configuracion
     */
    Configuracion actualizaConfiguracion(Configuracion conf);
}
