package com.francisco.kazoku.servicios.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.francisco.kazoku.basedatos.entities.Alergia;
import com.francisco.kazoku.basedatos.entities.Usuario;

/**
 * 
 * @author Francisco Moro <jfmoro@gmail.com>
 * @since 0.1
 *
 */
public class UsuarioDto implements Serializable{

    /** Constante serialVersionUID */
    private static final long serialVersionUID = 3635127848113911388L;
    
    private int id;
    private String nombre;
    private Boolean usaClave;
    private String clave;
    private Date fechaNacimiento;
    private String dni;
    private String pasaporte;
    private String segSocial;
    private String grupoSanguineo;
    private String codigoAlergias;
    private String textoAlergias;
    
    /**
     * Constructor con parametros
     */
    public UsuarioDto(){
        
    }
    
    /**
     * Constructor con parametros
     * 
     * @param id
     * @param nombre
     * @param usaClave
     * @param clave
     * @param fechaNacimiento
     * @param dni
     * @param pasaporte
     * @param segSocial
     */
    public UsuarioDto(int id, String nombre, String clave, Date fechaNacimiento, String dni,
            String pasaporte, String segSocial, String codigoAlergias){
        this.id = id;
        this.nombre = nombre;
        this.clave = clave;
        this.fechaNacimiento = fechaNacimiento;
        this.dni = dni;
        this.pasaporte = pasaporte;
        this.segSocial = segSocial;
        this.codigoAlergias = codigoAlergias;
    }
    
    /**
     * Transforma una entity en un dto
     * 
     * @param usuario
     * @return usuarioDto
     */
    public UsuarioDto entityToDto(Usuario usuario){
        this.setId(usuario.getId());
        this.setNombre(usuario.getNombre());
        if(usuario.getClave() != null && !"".equals(usuario.getClave())){
            this.usaClave = true;
        }
        this.setFechaNacimiento(usuario.getFechaNacimiento());
        this.setDni(usuario.getDni());
        this.setPasaporte(usuario.getPasaporte());
        this.setSegSocial(usuario.getSeguridadSocial());
        this.setGrupoSanguineo(usuario.getGrupoSanguineo());
//        if(!usuario.getListaAlergias().isEmpty()){
//            List<Alergia> listaAlergias = usuario.getListaAlergias();
//            this.codigoAlergias = "";
//            this.textoAlergias = "";
//            for(Alergia alergia : listaAlergias){
//                if(this.codigoAlergias != ""){
//                    this.codigoAlergias += ",";
//                    this.textoAlergias += ", ";
//                }
//                this.codigoAlergias += alergia.getId();
//                this.textoAlergias += alergia.getElemento();
//            }
//        }
        return this;
    }
    
    /**
     * Transforma un dto en una entity
     * 
     * @param usuarioDto
     * @return usuario
     */
    public Usuario dtoToEntity(UsuarioDto usuarioDto){
        Usuario usuario = new Usuario();
        if(usuarioDto.getId() != 0){
            usuario.setId(usuarioDto.getId());
        }
        usuario.setNombre(usuarioDto.getNombre());
        usuario.setClave(usuarioDto.getClave());
        usuario.setFechaNacimiento(usuarioDto.getFechaNacimiento());
        usuario.setDni(usuarioDto.getDni());
        usuario.setPasaporte(usuarioDto.getPasaporte());
        usuario.setSeguridadSocial(usuarioDto.getSegSocial());
        usuario.setGrupoSanguineo(usuarioDto.getGrupoSanguineo());
        return usuario;
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
    public Boolean getUsaClave(){
        return usaClave;
    }

    /**
     * @param usaClave the usaClave to set
     */
    public void setUsaClave(Boolean usaClave){
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

    /**
     * @return the grupoSanguineo
     */
    public String getGrupoSanguineo(){
        return grupoSanguineo;
    }

    /**
     * @param grupoSanguineo the grupoSanguineo to set
     */
    public void setGrupoSanguineo(String grupoSanguineo){
        this.grupoSanguineo = grupoSanguineo;
    }

    /**
     * @return the codigoAlergias
     */
    public String getCodigoAlergias(){
        return codigoAlergias;
    }

    /**
     * @param codigoAlergias the codigoAlergias to set
     */
    public void setCodigoAlergias(String codigoAlergias){
        this.codigoAlergias = codigoAlergias;
    }

    /**
     * @return the textoAlergias
     */
    public String getTextoAlergias(){
        return textoAlergias;
    }

    /**
     * @param textoAlergias the textoAlergias to set
     */
    public void setTextoAlergias(String textoAlergias){
        this.textoAlergias = textoAlergias;
    }
    
}
