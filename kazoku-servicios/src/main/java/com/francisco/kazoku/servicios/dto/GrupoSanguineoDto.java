package com.francisco.kazoku.servicios.dto;

import java.io.Serializable;

import com.francisco.kazoku.basedatos.entities.GrupoSanguineo;

public class GrupoSanguineoDto implements Serializable{

    /** Constante serialVersionUID */
    private static final long serialVersionUID = 9056202625273265319L;
    
    private String grupoSanguineo;
    
    /**
     * Constructor sin parametros
     */
    public GrupoSanguineoDto(){
        
    }
    
    /**
     * Constructor con parametros
     * 
     * @param grupoSanguineo
     */
    public GrupoSanguineoDto(String grupoSanguineo){
        this.grupoSanguineo = grupoSanguineo;
    }
    
    /**
     * Convierte una entity en un dto
     * 
     * @param grupo
     * @return GrupoSanguineoDto
     */
    public GrupoSanguineoDto entityToDto(GrupoSanguineo grupo){
        this.grupoSanguineo = grupo.getGrupo();
        return this;
    }
    
    /**
     * @return the grupoSanguineo
     */
    public String getGrupoSanguineo(){
        return grupoSanguineo;
    }

    /**
     * @param grupo the grupoSanguineo to set
     */
    public void setGrupo(String grupoSanguineo){
        this.grupoSanguineo = grupoSanguineo;
    }
    
    
}
