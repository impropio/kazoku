package com.francisco.kazoku.servicios.dto;

import java.io.Serializable;

import com.francisco.kazoku.basedatos.entities.Medidas;

public class MedidasDto implements Serializable{

    /** Constante serialVersionUID. */
    private static final long serialVersionUID = 1147523495753164758L;
    
    private Integer idMedida;
    private String medida;
    
    public MedidasDto(){
        
    }
    
    public MedidasDto(Integer idMedida, String medida){
        this.idMedida = idMedida;
        this.medida = medida;
    }
    
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
