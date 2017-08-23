package com.francisco.kazoku.servicios.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.francisco.kazoku.comunicacion.dto.CiudadClima;
import com.francisco.kazoku.comunicacion.dto.PrediccionClima;

/**
 * 
 * @author Francisco Moro <jfmoro@gmail.com>
 * @since 0.1
 *
 */
public class CiudadClimaDto implements Serializable{
	
    /** Constante serialVersionUID. */
    private static final long serialVersionUID = -8294904471814928933L;
    
    private String id;
    private String nombre;
    private BigDecimal longitud;
    private BigDecimal latitud;
    private String pais;
    private Integer poblacion;
    private Date amanecer;
    private Date atardecer;
    private List<PrediccionClimaDto> predicciones;
    
    /**
     * Constructor sin parámetros
     */
    public CiudadClimaDto(){
        
    }
    
    /**
     * Constructor con parámetros
     * 
     * @param id
     * @param nombre
     * @param longitud
     * @param latitud
     * @param pais
     * @param poblacion
     * @param amanecer
     * @param atardecer
     */
    public CiudadClimaDto(String id, String nombre, BigDecimal longitud, BigDecimal latitud, 
            String pais, Integer poblacion, Date amanecer, Date atardecer){
        this.id = id;
        this.nombre = nombre;
        this.longitud = longitud;
        this.latitud = latitud;
        this.pais = pais;
        this.poblacion = poblacion;
        this.amanecer = amanecer;
        this.atardecer = atardecer;
    }
    
    /**
     * Transforma el objeto CiudadClima en el Dto
     * 
     * @param ciudad
     * @return
     */
    public CiudadClimaDto objectToDto(CiudadClima ciudad){
        this.id = ciudad.getId();
        this.nombre = ciudad.getNombre();
        this.longitud = ciudad.getLongitud();
        this.latitud = ciudad.getLatitud();
        this.pais = ciudad.getPais();
        this.poblacion = ciudad.getPoblacion();
        this.amanecer = ciudad.getAmanecer();
        this.atardecer = ciudad.getAtardecer();
        if(!ciudad.getPredicciones().isEmpty()){
            this.predicciones = new ArrayList<PrediccionClimaDto>();
            for(PrediccionClima prediccion : ciudad.getPredicciones()){
                PrediccionClimaDto pred = new PrediccionClimaDto();
                predicciones.add(pred.objectToDto(prediccion));
            }
        }
        return this;
    }
    
    /**
     * @return the id
     */
    public String getId() {
        return id;
    }
    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }
    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * @return the longitud
     */
    public BigDecimal getLongitud() {
        return longitud;
    }
    /**
     * @param longitud the longitud to set
     */
    public void setLongitud(BigDecimal longitud) {
        this.longitud = longitud;
    }
    /**
     * @return the latitud
     */
    public BigDecimal getLatitud() {
        return latitud;
    }
    /**
     * @param latitud the latitud to set
     */
    public void setLatitud(BigDecimal latitud) {
        this.latitud = latitud;
    }
    /**
     * @return the pais
     */
    public String getPais() {
        return pais;
    }
    /**
     * @param pais the pais to set
     */
    public void setPais(String pais) {
        this.pais = pais;
    }
    /**
     * @return the poblacion
     */
    public Integer getPoblacion() {
        return poblacion;
    }
    /**
     * @param poblacion the poblacion to set
     */
    public void setPoblacion(Integer poblacion) {
        this.poblacion = poblacion;
    }
    /**
     * @return the amanecer
     */
    public Date getAmanecer() {
        return amanecer;
    }
    /**
     * @param amanecer the amanecer to set
     */
    public void setAmanecer(Date amanecer) {
        this.amanecer = amanecer;
    }
    /**
     * @return the atardecer
     */
    public Date getAtardecer() {
        return atardecer;
    }
    /**
     * @param atardecer the atardecer to set
     */
    public void setAtardecer(Date atardecer) {
        this.atardecer = atardecer;
    }
    /**
     * @return the predicciones
     */
    public List<PrediccionClimaDto> getPredicciones() {
        return predicciones;
    }
    /**
     * @param predicciones the predicciones to set
     */
    public void setPredicciones(List<PrediccionClimaDto> predicciones) {
        this.predicciones = predicciones;
    }
    
}
