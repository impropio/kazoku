package com.francisco.kazoku.servicios.dto;

import java.io.Serializable;

import com.francisco.kazoku.basedatos.entities.Pais;

public class PaisDto implements Serializable{

    /** Constante serialVersionUID. */
    private static final long serialVersionUID = 2518427943637309310L;
    
    private String codigoPais;
    private String pais;
    
    public PaisDto(){
        
    }
    
    public PaisDto(String codigoPais, String pais){
        this.codigoPais = codigoPais;
        this.pais = pais;
    }
    
    public PaisDto entityToDto(Pais pais){
        this.codigoPais = pais.getCodigo();
        this.pais = pais.getPais();
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
     * @return the pais
     */
    public String getPais(){
        return pais;
    }
    /**
     * @param pais the pais to set
     */
    public void setPais(String pais){
        this.pais = pais;
    }
    
}
