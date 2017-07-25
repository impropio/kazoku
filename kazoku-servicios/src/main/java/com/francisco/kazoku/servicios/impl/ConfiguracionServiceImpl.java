package com.francisco.kazoku.servicios.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.francisco.kazoku.basedatos.entities.Configuracion;
import com.francisco.kazoku.basedatos.interfaces.ConfiguracionDaoI;
import com.francisco.kazoku.servicios.dto.ConfiguracionDto;
import com.francisco.kazoku.servicios.interfaces.ConfiguracionServiceI;

@Service
public class ConfiguracionServiceImpl implements ConfiguracionServiceI{
    
    @Autowired
    private ConfiguracionDaoI configDao;
    
    @Override
    public ConfiguracionDto getConfiguracion(){
        Configuracion conf = configDao.getConfiguracion();
        ConfiguracionDto confDto = new ConfiguracionDto();
        return confDto.entityToDto(conf);
    }
    
}
