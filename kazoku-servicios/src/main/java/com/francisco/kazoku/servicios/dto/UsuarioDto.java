package com.francisco.kazoku.servicios.dto;

import java.io.Serializable;
import java.util.Date;

public class UsuarioDto implements Serializable{

    /** Constante serialVersionUID */
    private static final long serialVersionUID = 3635127848113911388L;
    
    private int id;
    private String nombre;
    private String usaClave;
    private String clave;
    private Date fechaNacimiento;
    private String dni;
    private String pasaporte;
    private String segSocial;
    
    public UsuarioDto(){
        
    }
    
    public UsuarioDto(int id, String nombre, String usaClave, String clave, Date fechaNacimiento, String dni,
            String pasaporte, String segSocial){
        this.id = id;
        this.nombre = nombre;
        this.usaClave = usaClave;
        this.clave = clave;
        this.fechaNacimiento = fechaNacimiento;
        this.dni = dni;
        this.pasaporte = pasaporte;
        this.segSocial = segSocial;
    }
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }
    /**
     * @param id the id to set
     */
    public void setId(int id) {
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
     * @return the usaClave
     */
    public String getUsaClave() {
        return usaClave;
    }
    /**
     * @param usaClave the usaClave to set
     */
    public void setUsaClave(String usaClave) {
        this.usaClave = usaClave;
    }
    /**
     * @return the clave
     */
    public String getClave() {
        return clave;
    }
    /**
     * @param clave the clave to set
     */
    public void setClave(String clave) {
        this.clave = clave;
    }
    /**
     * @return the fechaNacimiento
     */
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }
    /**
     * @param fechaNacimiento the fechaNacimiento to set
     */
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    /**
     * @return the dni
     */
    public String getDni() {
        return dni;
    }
    /**
     * @param dni the dni to set
     */
    public void setDni(String dni) {
        this.dni = dni;
    }
    /**
     * @return the pasaporte
     */
    public String getPasaporte() {
        return pasaporte;
    }
    /**
     * @param pasaporte the pasaporte to set
     */
    public void setPasaporte(String pasaporte) {
        this.pasaporte = pasaporte;
    }
    /**
     * @return the segSocial
     */
    public String getSegSocial() {
        return segSocial;
    }
    /**
     * @param segSocial the segSocial to set
     */
    public void setSegSocial(String segSocial) {
        this.segSocial = segSocial;
    }
    
    
}
