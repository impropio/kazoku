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
	@JoinColumn(name="tipo")
	private TipoAlergia tipoAlergia;

	//bi-directional many-to-one association to Gravedad
	@ManyToOne
	@JoinColumn(name="gravedad", updatable=false, insertable=false)
	private GravedadAlergia gravedadAlergia;

	//bi-directional many-to-many association to Usuario
	@ManyToMany(mappedBy="listaAlergias")
	private List<Usuario> listaUsuarios;

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

	public GravedadAlergia getGravedadAlergia() {
		return this.gravedadAlergia;
	}

	public void setGravedadAlergia(GravedadAlergia gravedadAlergia) {
		this.gravedadAlergia = gravedadAlergia;
	}

	public List<Usuario> getListaUsuarios() {
		return this.listaUsuarios;
	}

	public void setListaUsuarios(List<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

}
