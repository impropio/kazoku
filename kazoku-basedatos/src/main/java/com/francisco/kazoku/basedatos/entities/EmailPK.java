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

	public EmailPK() {
	}
	public int getUsuario() {
		return this.usuario;
	}
	public void setUsuario(int usuario) {
		this.usuario = usuario;
	}
	public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

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

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.usuario;
		hash = hash * prime + this.email.hashCode();
		
		return hash;
	}
}