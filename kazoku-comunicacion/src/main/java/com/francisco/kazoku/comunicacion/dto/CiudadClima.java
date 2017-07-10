package com.francisco.kazoku.comunicacion.dto;

import java.math.BigDecimal;
import java.util.List;

public class CiudadClima{
	
    private String id;
    private String nombre;
    private BigDecimal longitud;
    private BigDecimal latitud;
    private String pais;
    private Integer poblacion;
    private String amanecer;
    private String atardecer;
    private List<PrediccionClima> predicciones;
    
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
    public String getAmanecer() {
        return amanecer;
    }
    /**
     * @param amanecer the amanecer to set
     */
    public void setAmanecer(String amanecer) {
        this.amanecer = amanecer;
    }
    /**
     * @return the atardecer
     */
    public String getAtardecer() {
        return atardecer;
    }
    /**
     * @param atardecer the atardecer to set
     */
    public void setAtardecer(String atardecer) {
        this.atardecer = atardecer;
    }
    /**
     * @return the predicciones
     */
    public List<PrediccionClima> getPredicciones() {
        return predicciones;
    }
    /**
     * @param predicciones the predicciones to set
     */
    public void setPredicciones(List<PrediccionClima> predicciones) {
        this.predicciones = predicciones;
    }
    
}
