package com.francisco.kazoku.servicios.dto;

import java.io.Serializable;

import com.francisco.kazoku.basedatos.entities.Configuracion;

public class ConfiguracionDto implements Serializable{

    /** Constante serialVersionUID */
    private static final long serialVersionUID = 2752135104008588850L;
    
    private String ciudad;
    
    /**
     * Constructor sin parámetros
     */
    public ConfiguracionDto(){
        
    }
    
    /**
     * Constructor con parámetros
     * @param ciudad
     */
    public ConfiguracionDto(String ciudad){
        this.ciudad = ciudad;
    }
    
    public ConfiguracionDto entityToDto(Configuracion conf){
        this.ciudad = conf.getCiudad() != null?conf.getCiudad().getNombre():"-";
        
        return this;
    }

    /**
     * @return the ciudad
     */
    public String getCiudad(){
        return ciudad;
    }

    /**
     * @param ciudad the ciudad to set
     */
    public void setCiudad(String ciudad){
        this.ciudad = ciudad;
    }
    
}
