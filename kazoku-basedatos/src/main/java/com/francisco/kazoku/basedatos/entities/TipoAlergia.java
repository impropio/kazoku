package com.francisco.kazoku.basedatos.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the kz_tipo_alergia database table.
 * 
 */
@Entity
@Table(name="kz_tipo_alergia")
@NamedQuery(name="TipoAlergia.findAll", query="SELECT t FROM TipoAlergia t")
public class TipoAlergia extends com.francisco.kazoku.basedatos.core.impl.AbstractEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private byte id;

	@Column(name="tipo_en")
	private String tipoEN;

	@Column(name="tipo_es")
	private String tipoES;

	//bi-directional many-to-one association to Alergia
	@OneToMany(mappedBy="tipoAlergia")
	private List<Alergia> listaAlergias;

	public TipoAlergia() {
	}

	public byte getId() {
		return this.id;
	}

	public void setId(byte id) {
		this.id = id;
	}

	public String getTipoEN() {
		return this.tipoEN;
	}

	public void setTipoEN(String tipoEN) {
		this.tipoEN = tipoEN;
	}

	public String getTipoES() {
		return this.tipoES;
	}

	public void setTipoES(String tipoES) {
		this.tipoES = tipoES;
	}

	public List<Alergia> getListaAlergias() {
		return this.listaAlergias;
	}

	public void setListaAlergias(List<Alergia> listaAlergias) {
		this.listaAlergias = listaAlergias;
	}

	public Alergia addAlergia(Alergia alergia) {
		getListaAlergias().add(alergia);
		alergia.setTipoAlergia(this);

		return alergia;
	}

	public Alergia removeAlergia(Alergia alergia) {
		getListaAlergias().remove(alergia);
		alergia.setTipoAlergia(null);

		return alergia;
	}

}
