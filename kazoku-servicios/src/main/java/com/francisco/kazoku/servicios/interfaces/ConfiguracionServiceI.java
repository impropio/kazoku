package com.francisco.kazoku.servicios.interfaces;

import com.francisco.kazoku.servicios.dto.ConfiguracionDto;

/**
 * 
 * @author Francisco Moro
 *
 */
public interface ConfiguracionServiceI{
    
    /**
     * Recupera la configuración
     * @return
     */
    ConfiguracionDto getConfiguracion();
}
