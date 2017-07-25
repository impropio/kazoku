package com.francisco.kazoku.basedatos.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the kz_ciudad database table.
 * 
 */
@Entity
@Table(name="kz_ciudad")
@NamedQuery(name="Ciudad.findAll", query="SELECT c FROM Ciudad c")
public class Ciudad extends com.francisco.kazoku.basedatos.core.impl.AbstractEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private double lat;

	private double lon;

	private String nombre;

	//bi-directional many-to-one association to Pais
	@ManyToOne
	@JoinColumn(name="pais")
	private Pais pais;

	//bi-directional many-to-one association to Configuracion
	@OneToMany(mappedBy="ciudad")
	private List<Configuracion> listaConfig;

	public Ciudad() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getLat() {
		return this.lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLon() {
		return this.lon;
	}

	public void setLon(double lon) {
		this.lon = lon;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Pais getPais() {
		return this.pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public List<Configuracion> getListaConfig() {
		return this.listaConfig;
	}

	public void setListaConfig(List<Configuracion> listaConfig) {
		this.listaConfig = listaConfig;
	}

	public Configuracion addConfig(Configuracion config) {
	    getListaConfig().add(config);
		config.setCiudad(this);

		return config;
	}

	public Configuracion removeConfig(Configuracion config) {
	    getListaConfig().remove(config);
		config.setCiudad(null);

		return config;
	}

}