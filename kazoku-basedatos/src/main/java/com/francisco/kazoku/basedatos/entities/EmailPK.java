package com.francisco.kazoku.basedatos.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the kz_email database table.
 * 
 */
@Embeddable
public class EmailPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private int usuario;

	private String email;

	/**
	 * Constructor sin parametros
	 */
	public EmailPK() {
	}
	
	/**
	 * Parametro usuario
	 * @return usuario
	 */
	public int getUsuario() {
		return this.usuario;
	}
	
	/**
	 * Parametro usuario
	 * @param usuario
	 */
	public void setUsuario(int usuario) {
		this.usuario = usuario;
	}
	
	/**
	 * Parametro email
	 * @return email
	 */
	public String getEmail() {
		return this.email;
	}
	
	/**
	 * Parametro email
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Compara la clave de objeto
	 */
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof EmailPK)) {
			return false;
		}
		EmailPK castOther = (EmailPK)other;
		return 
			(this.usuario == castOther.usuario)
			&& this.email.equals(castOther.email);
	}

	/**
	 * identificador hashCode
	 */
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.usuario;
		hash = hash * prime + this.email.hashCode();
		
		return hash;
	}
	
}
