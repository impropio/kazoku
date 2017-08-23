package com.francisco.kazoku.servicios.dto;

import java.io.Serializable;

import com.francisco.kazoku.basedatos.entities.Configuracion;

/**
 * 
 * @author Francisco Moro <jfmoro@gmail.com>
 * @since 0.1
 *
 */
public class ConfiguracionDto implements Serializable{

    /** Constante serialVersionUID */
    private static final long serialVersionUID = 2752135104008588850L;
    
    private String codigoPais;
    private String idCiudad;
    private Integer idMedida;
    private String unidadesMedida;
    private String climaApiId;
    private Integer climaNumeroDias;
    private String idioma;
    
    /**
     * Constructor sin parámetros
     */
    public ConfiguracionDto(){
        
    }
    
    /**
     * Constructor con parámetros
     * @param ciudad
     */
    public ConfiguracionDto(String codigoPais, String idCiudad, Integer idMedida, String unidades, String apiId, Integer numeroDias, String idioma){
        this.idCiudad = idCiudad;
        this.idMedida = idMedida;
        this.unidadesMedida = unidades;
        this.climaApiId = apiId;
        this.climaNumeroDias = numeroDias;
        this.idioma = idioma;
    }
    
    /**
     * Transforma la entity en el dto
     * @param conf
     * @return configuracionDto
     */
    public ConfiguracionDto entityToDto(Configuracion conf){
        this.codigoPais = conf.getCiudad() != null?conf.getCiudad().getPais().getCodigo():"-";
        this.idioma = conf.getIdioma();
        this.idCiudad = conf.getCiudad() != null?String.valueOf(conf.getCiudad().getId()):"-";
        this.setIdMedida(conf.getMedidas().getId());
        this.unidadesMedida = conf.getMedidas().getMedidaEN(); //Se recupera en inglés porque es como lo espera el webservice
        this.climaApiId = conf.getClimaApiId();
        this.climaNumeroDias = conf.getClimaNumeroDias() != null?conf.getClimaNumeroDias():0;
        return this;
    }

    /**
     * @return the codigoPais
     */
    public String getCodigoPais(){
        return codigoPais;
    }

    /**
     * @param codigoPais the codigoPais to set
     */
    public void setCodigoPais(String codigoPais){
        this.codigoPais = codigoPais;
    }

    /**
     * @return the idCiudad
     */
    public String getIdCiudad(){
        return idCiudad;
    }

    /**
     * @param idCiudad the idCiudad to set
     */
    public void setIdCiudad(String idCiudad){
        this.idCiudad = idCiudad;
    }

    /**
     * @return the idMedida
     */
    public Integer getIdMedida(){
        return idMedida;
    }

    /**
     * @param idMedida the idMedida to set
     */
    public void setIdMedida(Integer idMedida){
        this.idMedida = idMedida;
    }

    /**
     * @return the unidadesMedida
     */
    public String getUnidadesMedida(){
        return unidadesMedida;
    }

    /**
     * @param unidadesMedida the unidadesMedida to set
     */
    public void setUnidadesMedida(String unidadesMedida){
        this.unidadesMedida = unidadesMedida;
    }

    /**
     * @return the climaApiId
     */
    public String getClimaApiId(){
        return climaApiId;
    }

    /**
     * @param climaApiId the climaApiId to set
     */
    public void setClimaApiId(String climaApiId){
        this.climaApiId = climaApiId;
    }

    /**
     * @return the climaNumeroDias
     */
    public Integer getClimaNumeroDias(){
        return climaNumeroDias;
    }

    /**
     * @param climaNumeroDias the climaNumeroDias to set
     */
    public void setClimaNumeroDias(Integer climaNumeroDias){
        this.climaNumeroDias = climaNumeroDias;
    }

    /**
     * @return the idioma
     */
    public String getIdioma(){
        return idioma;
    }

    /**
     * @param idioma the idioma to set
     */
    public void setIdioma(String idioma){
        this.idioma = idioma;
    }
    
}
