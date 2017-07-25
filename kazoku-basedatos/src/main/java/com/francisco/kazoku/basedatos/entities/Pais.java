package com.francisco.kazoku.basedatos.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the kz_pais database table.
 * 
 */
@Entity
@Table(name="kz_pais")
@NamedQuery(name="Pais.findAll", query="SELECT p FROM Pais p")
public class Pais extends com.francisco.kazoku.basedatos.core.impl.AbstractEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String codigo;

	@Column(name="pais_es")
	private String paisEs;

	//bi-directional many-to-one association to Ciudad
	@OneToMany(mappedBy="pais")
	private List<Ciudad> listaCiudades;

	public Pais() {
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getPaisEs() {
		return this.paisEs;
	}

	public void setPaisEs(String paisEs) {
		this.paisEs = paisEs;
	}

	public List<Ciudad> getListaCiudades() {
		return this.listaCiudades;
	}

	public void setListaCiudades(List<Ciudad> listaCiudades) {
		this.listaCiudades = listaCiudades;
	}

	public Ciudad addCiudad(Ciudad ciudad) {
	    getListaCiudades().add(ciudad);
		ciudad.setPais(this);

		return ciudad;
	}

	public Ciudad removeCiudad(Ciudad ciudad) {
	    getListaCiudades().remove(ciudad);
		ciudad.setPais(null);

		return ciudad;
	}

}