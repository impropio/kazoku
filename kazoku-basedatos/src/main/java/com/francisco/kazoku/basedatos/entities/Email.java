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

	public Email() {
	}

	public EmailPK getId() {
		return this.id;
	}

	public void setId(EmailPK id) {
		this.id = id;
	}

	public String getAlias() {
		return this.alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public byte getPrincipal() {
		return this.principal;
	}

	public void setPrincipal(byte principal) {
		this.principal = principal;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}