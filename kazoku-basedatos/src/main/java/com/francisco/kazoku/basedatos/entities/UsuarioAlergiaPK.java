package com.francisco.kazoku.basedatos.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the kz_usuario_alergia database table.
 * 
 */
@Embeddable
public class UsuarioAlergiaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private int usuario;

	@Column(insertable=false, updatable=false)
	private int alergia;

	public UsuarioAlergiaPK() {
	}
	public int getUsuario() {
		return this.usuario;
	}
	public void setUsuario(int usuario) {
		this.usuario = usuario;
	}
	public int getAlergia() {
		return this.alergia;
	}
	public void setAlergia(int alergia) {
		this.alergia = alergia;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof UsuarioAlergiaPK)) {
			return false;
		}
		UsuarioAlergiaPK castOther = (UsuarioAlergiaPK)other;
		return 
			(this.usuario == castOther.usuario)
			&& (this.alergia == castOther.alergia);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.usuario;
		hash = hash * prime + this.alergia;
		
		return hash;
	}
}