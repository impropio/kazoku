package com.francisco.kazoku.servicios.dto;

import java.io.Serializable;

import com.francisco.kazoku.basedatos.entities.Pais;

/**
 * 
 * @author Francisco Moro <jfmoro@gmail.com>
 * @since 0.1
 *
 */
public class PaisDto implements Serializable{

    /** Constante serialVersionUID. */
    private static final long serialVersionUID = 2518427943637309310L;
    
    private String codigoPais;
    private String pais;
    
    /**
     * Constructor sin parametros
     */
    public PaisDto(){
        
    }
    
    /**
     * Constructor con parametros
     * 
     * @param codigoPais
     * @param pais
     */
    public PaisDto(String codigoPais, String pais){
        this.codigoPais = codigoPais;
        this.pais = pais;
    }
    
    /**
     * Transforma la entity en el dto
     * 
     * @param pais
     * @return pais
     */
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
