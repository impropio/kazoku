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

	@Column(name="grupo_sang")
	private String grupoSanguineo;

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

	//bi-directional many-to-one association to UsuarioAlergia
	@OneToMany(mappedBy="usuario")
	private List<UsuarioAlergia> listaUsuarioAlergias;

	public Usuario() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getClave() {
		return this.clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getDni() {
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Date getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getGrupoSanguineo() {
		return this.grupoSanguineo;
	}

	public void setGrupoSanguineo(String grupoSanguineo) {
		this.grupoSanguineo = grupoSanguineo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPasaporte() {
		return this.pasaporte;
	}

	public void setPasaporte(String pasaporte) {
		this.pasaporte = pasaporte;
	}

	public String getSeguridadSocial() {
		return this.seguridadSocial;
	}

	public void setSeguridadSocial(String seguridadSocial) {
		this.seguridadSocial = seguridadSocial;
	}

	public byte getUsaClave() {
		return this.usaClave;
	}

	public void setUsaClave(byte usaClave) {
		this.usaClave = usaClave;
	}

	public List<Email> getListaEmails() {
		return this.listaEmails;
	}

	public void setListaEmails(List<Email> listaEmails) {
		this.listaEmails = listaEmails;
	}

	public Email addEmail(Email email) {
		getListaEmails().add(email);
		email.setUsuario(this);

		return email;
	}

	public Email removeEmail(Email email) {
		getListaEmails().remove(email);
		email.setUsuario(null);

		return email;
	}

	public List<Garantia> getListaGarantias() {
		return this.listaGarantias;
	}

	public void setListaGarantias(List<Garantia> listaGarantias) {
		this.listaGarantias = listaGarantias;
	}

	public Garantia addGarantia(Garantia garantia) {
		getListaGarantias().add(garantia);
		garantia.setUsuario(this);

		return garantia;
	}

	public Garantia removeGarantia(Garantia garantia) {
		getListaGarantias().remove(garantia);
		garantia.setUsuario(null);

		return garantia;
	}

	public List<PesoUsuario> getListaPesoUsuarios() {
		return this.listaPesoUsuarios;
	}

	public void setListaPesoUsuarios(List<PesoUsuario> listaPesoUsuarios) {
		this.listaPesoUsuarios = listaPesoUsuarios;
	}

	public PesoUsuario addPesoUsuario(PesoUsuario pesoUsuario) {
		getListaPesoUsuarios().add(pesoUsuario);
		pesoUsuario.setUsuario(this);

		return pesoUsuario;
	}

	public PesoUsuario removePesoUsuario(PesoUsuario pesoUsuario) {
		getListaPesoUsuarios().remove(pesoUsuario);
		pesoUsuario.setUsuario(null);

		return pesoUsuario;
	}

	public List<Tarea> getListaTareas() {
		return this.listaTareas;
	}

	public void setListaTareas(List<Tarea> listaTareas) {
		this.listaTareas = listaTareas;
	}

	public Tarea addTarea(Tarea tarea) {
		getListaTareas().add(tarea);
		tarea.setUsuario(this);

		return tarea;
	}

	public Tarea removeTarea(Tarea tarea) {
		getListaTareas().remove(tarea);
		tarea.setUsuario(null);

		return tarea;
	}

	public List<Telefono> getListaTelefonos() {
		return this.listaTelefonos;
	}

	public void setListaTelefonos(List<Telefono> listaTelefonos) {
		this.listaTelefonos = listaTelefonos;
	}

	public Telefono addTelefono(Telefono telefono) {
		getListaTelefonos().add(telefono);
		telefono.setUsuario(this);

		return telefono;
	}

	public Telefono removeTelefono(Telefono telefono) {
		getListaTelefonos().remove(telefono);
		telefono.setUsuario(null);

		return telefono;
	}

	public List<UsuarioAlergia> getListaUsuarioAlergias() {
		return this.listaUsuarioAlergias;
	}

	public void setListaUsuarioAlergias(List<UsuarioAlergia> listaUsuarioAlergias) {
		this.listaUsuarioAlergias = listaUsuarioAlergias;
	}

	public UsuarioAlergia addUsuarioAlergia(UsuarioAlergia usuarioAlergia) {
		getListaUsuarioAlergias().add(usuarioAlergia);
		usuarioAlergia.setUsuario(this);

		return usuarioAlergia;
	}

	public UsuarioAlergia removeUsuarioAlergia(UsuarioAlergia usuarioAlergia) {
		getListaUsuarioAlergias().remove(usuarioAlergia);
		usuarioAlergia.setUsuario(null);

		return usuarioAlergia;
	}

}
