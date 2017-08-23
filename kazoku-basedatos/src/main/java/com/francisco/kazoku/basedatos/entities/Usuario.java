package com.francisco.kazoku.basedatos.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the kz_usuario database table.
 * 
 */
@Entity
@Table(name="kz_usuario")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario extends com.francisco.kazoku.basedatos.core.impl.AbstractEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String clave;

	private String dni;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_nacimiento")
	private Date fechaNacimiento;

	private String nombre;

	private String pasaporte;

	@Column(name="seguridad_social")
	private String seguridadSocial;

	@Column(name="usa_clave")
	private byte usaClave;

	//bi-directional many-to-one association to Email
	@OneToMany(mappedBy="usuario")
	private List<Email> listaEmails;

	//bi-directional many-to-one association to Garantia
	@OneToMany(mappedBy="usuario")
	private List<Garantia> listaGarantias;

	//bi-directional many-to-one association to PesoUsuario
	@OneToMany(mappedBy="usuario")
	private List<PesoUsuario> listaPesoUsuarios;

	//bi-directional many-to-one association to Tarea
	@OneToMany(mappedBy="usuario")
	private List<Tarea> listaTareas;

	//bi-directional many-to-one association to Telefono
	@OneToMany(mappedBy="usuario")
	private List<Telefono> listaTelefonos;

	@Column(name="grupo_sang")
	private String grupoSanguineo;

	//bi-directional many-to-many association to Alergia
	@ManyToMany
	@JoinTable(
		name="kz_usuario_alergia"
		, joinColumns={
			@JoinColumn(name="usuario")
			}
		, inverseJoinColumns={
			@JoinColumn(name="alergia")
			}
		)
	private List<Alergia> listaAlergias;

	/**
	 * Constructor sin parametros
	 */
	public Usuario() {
	}

	/**
	 * Paremetro id
	 * @return id
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * Parametro id
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Parametro clave
	 * @return clave
	 */
	public String getClave() {
		return this.clave;
	}

	/**
	 * Parametro clave
	 * @param clave
	 */
	public void setClave(String clave) {
		this.clave = clave;
	}

	/**
	 * Parametro dni
	 * @return dni
	 */
	public String getDni() {
		return this.dni;
	}

	/**
	 * Parametro dni
	 * @param dni
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}

	/**
	 * Parametro fechaNacimiento
	 * @return fechaNacimiento
	 */
	public Date getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	/**
	 * Parametro fechaNacimiento
	 * @param fechaNacimiento
	 */
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	/**
	 * Parametro nombre
	 * @return nombre
	 */
	public String getNombre() {
		return this.nombre;
	}

	/**
	 * Parametro nombre
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Parametro pasaporte
	 * @return pasaporte
	 */
	public String getPasaporte() {
		return this.pasaporte;
	}

	/**
	 * Parametro pasaporte
	 * @param pasaporte
	 */
	public void setPasaporte(String pasaporte) {
		this.pasaporte = pasaporte;
	}

	/**
	 * Parametro seguridadSocial
	 * @return seguridadSocial
	 */
	public String getSeguridadSocial() {
		return this.seguridadSocial;
	}

	/**
	 * Parametro seguridadSocial
	 * @param seguridadSocial
	 */
	public void setSeguridadSocial(String seguridadSocial) {
		this.seguridadSocial = seguridadSocial;
	}

	/**
	 * Parametro usaClave
	 * @return usaClave
	 */
	public byte getUsaClave() {
		return this.usaClave;
	}

	/**
	 * Parametro usaClave
	 * @param usaClave
	 */
	public void setUsaClave(byte usaClave) {
		this.usaClave = usaClave;
	}

	/**
	 * Parametro listaEmails
	 * @return listaEmails
	 */
	public List<Email> getListaEmails() {
		return this.listaEmails;
	}

	/**
	 * Parametro listaEmails
	 * @param listaEmails
	 */
	public void setListaEmails(List<Email> listaEmails) {
		this.listaEmails = listaEmails;
	}

	/**
	 * Añade un email a la lista
	 * @param email
	 * @return email
	 */
	public Email addEmail(Email email) {
		getListaEmails().add(email);
		email.setUsuario(this);

		return email;
	}

	/**
	 * Elimina un email de la lista
	 * @param email
	 * @return email
	 */
	public Email removeEmail(Email email) {
		getListaEmails().remove(email);
		email.setUsuario(null);

		return email;
	}

	/**
	 * Parametro listaGarantias
	 * @return listaGarantias
	 */
	public List<Garantia> getListaGarantias() {
		return this.listaGarantias;
	}

	/**
	 * Parametro listaGarantias
	 * @param listaGarantias
	 */
	public void setListaGarantias(List<Garantia> listaGarantias) {
		this.listaGarantias = listaGarantias;
	}

	/**
	 * Añade una garantia a la lista
	 * @param garantia
	 * @return garantia
	 */
	public Garantia addGarantia(Garantia garantia) {
		getListaGarantias().add(garantia);
		garantia.setUsuario(this);

		return garantia;
	}

	/**
	 * Elimina una garantia de la lista
	 * @param garantia
	 * @return garantia
	 */
	public Garantia removeGarantia(Garantia garantia) {
		getListaGarantias().remove(garantia);
		garantia.setUsuario(null);

		return garantia;
	}

	/**
	 * Parametro listaPesoUsuarios
	 * @return listaPesoUsuarios
	 */
	public List<PesoUsuario> getListaPesoUsuarios() {
		return this.listaPesoUsuarios;
	}

	/**
	 * Parametro listaPesoUsuarios
	 * @param listaPesoUsuarios
	 */
	public void setListaPesoUsuarios(List<PesoUsuario> listaPesoUsuarios) {
		this.listaPesoUsuarios = listaPesoUsuarios;
	}

	/**
	 * Añade un pesoUsuario a la lista
	 * @param pesoUsuario
	 * @return pesoUsuario
	 */
	public PesoUsuario addPesoUsuario(PesoUsuario pesoUsuario) {
		getListaPesoUsuarios().add(pesoUsuario);
		pesoUsuario.setUsuario(this);

		return pesoUsuario;
	}

	/**
	 * Elimina un pesoUsuario de la lista
	 * @param pesoUsuario
	 * @return pesoUsuario
	 */
	public PesoUsuario removePesoUsuario(PesoUsuario pesoUsuario) {
		getListaPesoUsuarios().remove(pesoUsuario);
		pesoUsuario.setUsuario(null);

		return pesoUsuario;
	}

	/**
	 * Parametro listaTareas
	 * @return listaTareas
	 */
	public List<Tarea> getListaTareas() {
		return this.listaTareas;
	}

	/**
	 * Parametro listaTareas
	 * @param listaTareas
	 */
	public void setListaTareas(List<Tarea> listaTareas) {
		this.listaTareas = listaTareas;
	}

	/**
	 * Añade una tarea a la lista
	 * @param tarea
	 * @return tarea
	 */
	public Tarea addTarea(Tarea tarea) {
		getListaTareas().add(tarea);
		tarea.setUsuario(this);

		return tarea;
	}

	/**
	 * Elimina una tarea de la lista
	 * @param tarea
	 * @return tarea
	 */
	public Tarea removeTarea(Tarea tarea) {
		getListaTareas().remove(tarea);
		tarea.setUsuario(null);

		return tarea;
	}

	/**
	 * Parametro listaTelefonos
	 * @return listaTelefonos
	 */
	public List<Telefono> getListaTelefonos() {
		return this.listaTelefonos;
	}

	/**
	 * Parametro listaTelefonos
	 * @param listaTelefonos
	 */
	public void setListaTelefonos(List<Telefono> listaTelefonos) {
		this.listaTelefonos = listaTelefonos;
	}

	/**
	 * Añade un telefono a la lista
	 * @param telefono
	 * @return telefono
	 */
	public Telefono addTelefono(Telefono telefono) {
		getListaTelefonos().add(telefono);
		telefono.setUsuario(this);

		return telefono;
	}

	/**
	 * Elimina un telefono de la lista
	 * @param telefono
	 * @return telefono
	 */
	public Telefono removeTelefono(Telefono telefono) {
		getListaTelefonos().remove(telefono);
		telefono.setUsuario(null);

		return telefono;
	}
	
	/**
     * Parametro idGrupoSanguineo
     * @return idGrupoSanguineo
     */
    public String getGrupoSanguineo() {
        return this.grupoSanguineo;
    }

    /**
     * Parametro idGrupoSanguineo
     * @param idGrupoSanguineo
     */
    public void setGrupoSanguineo(String grupoSanguineo) {
        this.grupoSanguineo = grupoSanguineo;
    }

	/**
	 * Parametro listaAlergias
	 * @return listaAlergias
	 */
	public List<Alergia> getListaAlergias() {
		return this.listaAlergias;
	}

	/**
	 * Parametro listaAlergias
	 * @param listaAlergias
	 */
	public void setListaAlergias(List<Alergia> listaAlergias) {
		this.listaAlergias = listaAlergias;
	}

}
