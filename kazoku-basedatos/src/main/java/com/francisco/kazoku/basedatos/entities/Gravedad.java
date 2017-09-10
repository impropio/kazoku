package com.francisco.kazoku.basedatos.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the kz_gravedad database table.
 * 
 */
@Entity
@Table(name="kz_gravedad")
@NamedQuery(name="Gravedad.findAll", query="SELECT g FROM Gravedad g")
public class Gravedad extends com.francisco.kazoku.basedatos.core.impl.AbstractEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private byte id;

	@Column(name="gravedad_en")
	private String gravedadEN;

	@Column(name="gravedad_es")
	private String gravedadES;

	//bi-directional many-to-one association to UsuarioAlergia
	@OneToMany(mappedBy="gravedad")
	private List<UsuarioAlergia> listaUsuarioAlergias;

	public Gravedad() {
	}

	public byte getId() {
		return this.id;
	}

	public void setId(byte id) {
		this.id = id;
	}

	public String getGravedadEN() {
		return this.gravedadEN;
	}

	public void setGravedadEN(String gravedadEN) {
		this.gravedadEN = gravedadEN;
	}

	public String getGravedadES() {
		return this.gravedadES;
	}

	public void setGravedadES(String gravedadES) {
		this.gravedadES = gravedadES;
	}

	public List<UsuarioAlergia> getListaUsuarioAlergias() {
		return this.listaUsuarioAlergias;
	}

	public void setListaUsuarioAlergias(List<UsuarioAlergia> listaUsuarioAlergias) {
		this.listaUsuarioAlergias = listaUsuarioAlergias;
	}

	public UsuarioAlergia addUsuarioAlergia(UsuarioAlergia usuarioAlergia) {
		getListaUsuarioAlergias().add(usuarioAlergia);
		usuarioAlergia.setGravedad(this);

		return usuarioAlergia;
	}

	public UsuarioAlergia removeUsuarioAlergia(UsuarioAlergia usuarioAlergia) {
		getListaUsuarioAlergias().remove(usuarioAlergia);
		usuarioAlergia.setGravedad(null);

		return usuarioAlergia;
	}

}