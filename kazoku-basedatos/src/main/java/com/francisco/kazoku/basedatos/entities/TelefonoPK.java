package com.francisco.kazoku.basedatos.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the kz_telefono database table.
 * 
 */
@Embeddable
public class TelefonoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private int usuario;

	private String telefono;

	/**
	 * Constructor sin parametros
	 */
	public TelefonoPK() {
	}
	
	/**
	 * Parametro usuario
	 * @return usuario
	 */
	public int getUsuario() {
		return this.usuario;
	}
	
	/**
	 * PArametro usuario
	 * @param usuario
	 */
	public void setUsuario(int usuario) {
		this.usuario = usuario;
	}
	
	/**
	 * Parametro telefono
	 * @return telefono
	 */
	public String getTelefono() {
		return this.telefono;
	}
	
	/**
	 * Parametro telefono
	 * @param telefono
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * Compara la clave del objeto
	 */
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof TelefonoPK)) {
			return false;
		}
		TelefonoPK castOther = (TelefonoPK)other;
		return 
			(this.usuario == castOther.usuario)
			&& this.telefono.equals(castOther.telefono);
	}

	/**
	 * identificador hashCode
	 */
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.usuario;
		hash = hash * prime + this.telefono.hashCode();
		
		return hash;
	}
	
}
