package com.francisco.kazoku.servicios.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.francisco.kazoku.basedatos.entities.Ciudad;
import com.francisco.kazoku.basedatos.entities.Configuracion;
import com.francisco.kazoku.basedatos.entities.Medidas;
import com.francisco.kazoku.basedatos.interfaces.CiudadDaoI;
import com.francisco.kazoku.basedatos.interfaces.ConfiguracionDaoI;
import com.francisco.kazoku.basedatos.interfaces.MedidasDaoI;
import com.francisco.kazoku.servicios.dto.ConfiguracionDto;
import com.francisco.kazoku.servicios.interfaces.ConfiguracionServiceI;

/**
 * 
 * @author Francisco Moro <jfmoro@gmail.com>
 * @since 0.1
 *
 */
@Service
public class ConfiguracionServiceImpl implements ConfiguracionServiceI{
    
    @Autowired
    private ConfiguracionDaoI configDao;
    
    @Autowired
    private CiudadDaoI ciudadDao;
    
    @Autowired
    private MedidasDaoI medidasDao;
    
    /**
     * Recupera la configuración básica de la aplicación
     * 
     * @return confDto
     */
    @Override
    public ConfiguracionDto getConfiguracion(){
        Configuracion conf = configDao.getConfiguracion();
        ConfiguracionDto confDto = new ConfiguracionDto();
        return confDto.entityToDto(conf);
    }
    
    /**
     * Actualiza la configuración básica de la aplicación
     * 
     * @param configDto
     * @return configDto -> con los parámetros actualizados
     */
    @Override
    @Transactional
    public ConfiguracionDto actualizaConfiguracion(ConfiguracionDto configDto){
        ConfiguracionDto confDto = new ConfiguracionDto();
        Configuracion config = configDao.getConfiguracion();
        
        if(configDto.getIdCiudad() != null && !"".equals(configDto.getIdCiudad())){
            Ciudad ciudad = ciudadDao.getCiudadById(Integer.parseInt(configDto.getIdCiudad()));
            config.setCiudad(ciudad);
        }
        if(configDto.getUnidadesMedida() != null && !"".equals(configDto.getUnidadesMedida())){
            Medidas medida = medidasDao.getMedidasById(Integer.parseInt(configDto.getUnidadesMedida()));
            config.setMedidas(medida);
        }
        if(configDto.getClimaApiId() != null && !"".equals(configDto.getClimaApiId())){
            config.setClimaApiId(configDto.getClimaApiId());
        }
        if(configDto.getClimaNumeroDias() != null && !"".equals(configDto.getClimaNumeroDias())){
            config.setClimaNumeroDias(configDto.getClimaNumeroDias());
        }
        if(configDto.getIdioma() != null && !"".equals(configDto.getIdioma())){
            config.setIdioma(configDto.getIdioma());
        }
        config = configDao.actualizaConfiguracion(config);
        confDto = confDto.entityToDto(config);
        
        return confDto;
    }
    
}
