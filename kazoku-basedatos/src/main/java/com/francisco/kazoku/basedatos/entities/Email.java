package com.francisco.kazoku.basedatos.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the kz_email database table.
 * 
 */
@Entity
@Table(name="kz_email")
@NamedQuery(name="Email.findAll", query="SELECT e FROM Email e")
public class Email extends com.francisco.kazoku.basedatos.core.impl.AbstractEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private EmailPK id;

	private String alias;

	private byte principal;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="usuario", updatable=false, insertable=false)
	private Usuario usuario;

	/**
	 * Constructor sin parametros
	 */
	public Email() {
	}

	/**
	 * id conpuesto de email
	 * @return id
	 */
	public EmailPK getId() {
		return this.id;
	}

	/**
	 * id compuesto de email
	 * @param id
	 */
	public void setId(EmailPK id) {
		this.id = id;
	}

	/**
	 * Parametro alias
	 * @return alias
	 */
	public String getAlias() {
		return this.alias;
	}

	/**
	 * Parametro alias
	 * @param alias
	 */
	public void setAlias(String alias) {
		this.alias = alias;
	}

	/**
	 * Parametro principal
	 * @return principal
	 */
	public byte getPrincipal() {
		return this.principal;
	}

	/**
	 * Parametro principal
	 * @param principal
	 */
	public void setPrincipal(byte principal) {
		this.principal = principal;
	}

	/**
	 * Parametro usuario
	 * @return usuario
	 */
	public Usuario getUsuario() {
		return this.usuario;
	}

	/**
	 * Parametro usuario
	 * @param usuario
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
