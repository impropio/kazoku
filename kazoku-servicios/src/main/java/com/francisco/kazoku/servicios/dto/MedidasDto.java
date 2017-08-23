package com.francisco.kazoku.servicios.dto;

import java.io.Serializable;

import com.francisco.kazoku.basedatos.entities.Medidas;

/**
 * 
 * @author Francisco Moro <jfmoro@gmail.com>
 * @since 0.1
 *
 */
public class MedidasDto implements Serializable{

    /** Constante serialVersionUID. */
    private static final long serialVersionUID = 1147523495753164758L;
    
    private Integer idMedida;
    private String medida;
    
    /**
     * Constructor sin parámetros
     */
    public MedidasDto(){
        
    }
    
    /**
     * Constructor con parámetros
     * 
     * @param idMedida
     * @param medida
     */
    public MedidasDto(Integer idMedida, String medida){
        this.idMedida = idMedida;
        this.medida = medida;
    }
    
    /**
     * Transforma la entity en el dto
     * 
     * @param medidas
     * @return medidasDto
     */
    public MedidasDto entityToDto(Medidas medidas){
        this.idMedida = medidas.getId();
        this.medida = medidas.getMedida() != null?medidas.getMedida():"metric";
        return this;
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
     * @return the medida
     */
    public String getMedida(){
        return medida;
    }
    /**
     * @param medida the medida to set
     */
    public void setMedida(String medida){
        this.medida = medida;
    }
    
}
