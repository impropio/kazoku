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

	/**
	 * Constructor sin parametros
	 */
	public Alergia() {
	}

	/**
	 * Parametro id
	 * @return id
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * Parametro id
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Parametro elemento
	 * @return elemento
	 */
	public String getElemento() {
		return this.elemento;
	}

	/**
	 * Parametro elemento
	 * @param elemento
	 */
	public void setElemento(String elemento) {
		this.elemento = elemento;
	}

	/**
	 * Parametro tipoAlergia
	 * @return tipoAlergia
	 */
	public TipoAlergia getTipoAlergia() {
		return this.tipoAlergia;
	}

	/**
	 * Parametro tipoAlergia
	 * @param tipoAlergia
	 */
	public void setTipoAlergia(TipoAlergia tipoAlergia) {
		this.tipoAlergia = tipoAlergia;
	}

	/**
	 * Parametro gravedadAlergia
	 * @return gravedadAlergia
	 */
	public GravedadAlergia getGravedadAlergia() {
		return this.gravedadAlergia;
	}

	/**
	 * Parametro gravedadAlergia
	 * @param gravedadAlergia
	 */
	public void setGravedadAlergia(GravedadAlergia gravedadAlergia) {
		this.gravedadAlergia = gravedadAlergia;
	}

	/**
	 * Parametro listaUsuarios
	 * @return listaUsuarios
	 */
	public List<Usuario> getListaUsuarios() {
		return this.listaUsuarios;
	}

	/**
	 * Parametro listaUsuarios
	 * @param listaUsuarios
	 */
	public void setListaUsuarios(List<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

}
