package com.francisco.kazoku.basedatos.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the kz_usuario_alergia database table.
 * 
 */
@Entity
@Table(name="kz_usuario_alergia")
@NamedQuery(name="UsuarioAlergia.findAll", query="SELECT u FROM UsuarioAlergia u")
public class UsuarioAlergia extends com.francisco.kazoku.basedatos.core.impl.AbstractEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private UsuarioAlergiaPK id;

	//bi-directional many-to-one association to Alergia
	@ManyToOne
	@JoinColumn(name="alergia", updatable=false, insertable=false)
	private Alergia alergia;

	//bi-directional many-to-one association to Gravedad
	@ManyToOne
	@JoinColumn(name="gravedad", updatable=false, insertable=false)
	private Gravedad gravedad;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="usuario", updatable=false, insertable=false)
	private Usuario usuario;

	public UsuarioAlergia() {
	}

	public UsuarioAlergiaPK getId() {
		return this.id;
	}

	public void setId(UsuarioAlergiaPK id) {
		this.id = id;
	}

	public Alergia getAlergia() {
		return this.alergia;
	}

	public void setAlergia(Alergia alergia) {
		this.alergia = alergia;
	}

	public Gravedad getGravedad() {
		return this.gravedad;
	}

	public void setGravedad(Gravedad gravedad) {
		this.gravedad = gravedad;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
