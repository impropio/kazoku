package com.francisco.kazoku.servicios.dto;

import java.io.Serializable;

import com.francisco.kazoku.basedatos.entities.Ciudad;

public class CiudadDto implements Serializable{

    /** Constante serialVersionUID */
    private static final long serialVersionUID = 6992520805780549768L;
    
    private Integer idCiudad;
    private String codPais;
    private String nombreCiudad;
    
    public CiudadDto(){
        
    }
    
    public CiudadDto(Integer idCiudad, String nombre, String codPais){
        this.idCiudad = idCiudad;
        this.nombreCiudad = nombre;
        this.codPais = codPais;
    }
    
    public CiudadDto entityToDto(Ciudad ciudad){
        this.idCiudad = ciudad.getId();
        this.codPais = ciudad.getCodPais();
        this.nombreCiudad = ciudad.getNombre();
        return this;
    }
    
    /**
     * @return the idCiudad
     */
    public int getIdCiudad(){
        return idCiudad;
    }
    /**
     * @param idCiudad the idCiudad to set
     */
    public void setIdCiudad(int idCiudad){
        this.idCiudad = idCiudad;
    }
    /**
     * @return the codPais
     */
    public String getCodPais(){
        return codPais;
    }
    /**
     * @param codPais the codPais to set
     */
    public void setCodPais(String codPais){
        this.codPais = codPais;
    }
    /**
     * @return the nombre
     */
    public String getNombreCiudad(){
        return nombreCiudad;
    }
    /**
     * @param nombre the nombre to set
     */
    public void setNombreCiudad(String nombre){
        this.nombreCiudad = nombre;
    }
    
}