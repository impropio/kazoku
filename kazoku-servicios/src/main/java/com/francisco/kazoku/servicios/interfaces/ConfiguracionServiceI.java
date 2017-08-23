package com.francisco.kazoku.servicios.interfaces;

import com.francisco.kazoku.servicios.dto.ConfiguracionDto;

/**
 * 
 * @author Francisco Moro <jfmoro@gmail.com>
 * @since 0.1
 *
 */
public interface ConfiguracionServiceI{
    
    /**
     * Recupera la configuración básica del sistema
     * 
     * @return configuracionDto
     */
    ConfiguracionDto getConfiguracion();
    
    /**
     * Actualiza la configuración básica del sistema
     * 
     * @param config
     * @return configuracionDto
     */
    ConfiguracionDto actualizaConfiguracion(ConfiguracionDto config);
    
}
