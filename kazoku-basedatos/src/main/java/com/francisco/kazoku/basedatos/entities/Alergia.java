package com.francisco.kazoku.basedatos.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the kz_alergia database table.
 * 
 */
@Entity
@Table(name="kz_alergia")
@NamedQuery(name="Alergia.findAll", query="SELECT a FROM Alergia a")
public class Alergia extends com.francisco.kazoku.basedatos.core.impl.AbstractEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String elemento;

	//bi-directional many-to-one association to TipoAlergia
	@ManyToOne
	@JoinColumn(name="tipo", updatable=false, insertable=false)
	private TipoAlergia tipoAlergia;

	//bi-directional many-to-one association to UsuarioAlergia
	@OneToMany(mappedBy="alergia")
	private List<UsuarioAlergia> ListaUsuarioAlergias;

	public Alergia() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getElemento() {
		return this.elemento;
	}

	public void setElemento(String elemento) {
		this.elemento = elemento;
	}

	public TipoAlergia getTipoAlergia() {
		return this.tipoAlergia;
	}

	public void setTipoAlergia(TipoAlergia tipoAlergia) {
		this.tipoAlergia = tipoAlergia;
	}

	public List<UsuarioAlergia> getUsuarioAlergias() {
		return this.ListaUsuarioAlergias;
	}

	public void setUsuarioAlergias(List<UsuarioAlergia> ListaUsuarioAlergias) {
		this.ListaUsuarioAlergias = ListaUsuarioAlergias;
	}

	public UsuarioAlergia addUsuarioAlergia(UsuarioAlergia usuarioAlergia) {
		getUsuarioAlergias().add(usuarioAlergia);
		usuarioAlergia.setAlergia(this);

		return usuarioAlergia;
	}

	public UsuarioAlergia removeUsuarioAlergia(UsuarioAlergia usuarioAlergia) {
		getUsuarioAlergias().remove(usuarioAlergia);
		usuarioAlergia.setAlergia(null);

		return usuarioAlergia;
	}

}
