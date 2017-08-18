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

	@Column(name="lat")
	private double lat;

	@Column(name="lon")
	private double lon;

	@Column(name="nombre")
	private String nombre;
	
	@Column(name="pais")
    private String codPais;
	
	//bi-directional many-to-one association to Pais
	@ManyToOne
	@JoinColumn(name="pais", updatable=false, insertable=false)
	private Pais pais;

	//bi-directional many-to-one association to Configuracion
	@OneToMany(mappedBy="ciudad")
	private List<Configuracion> listaConfig;

	/**
	 * Constructor sin parametros
	 */
	public Ciudad() {
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
	 * Parametro lat -> latitud
	 * @return lat
	 */
	public double getLat() {
		return this.lat;
	}

	/**
	 * Parametro lat -> latitud
	 * @param lat
	 */
	public void setLat(double lat) {
		this.lat = lat;
	}

	/**
	 * Parametro lon -> longitud
	 * @return lon
	 */
	public double getLon() {
		return this.lon;
	}

	/**
	 * Parametro lon -> longitud
	 * @param lon
	 */
	public void setLon(double lon) {
		this.lon = lon;
	}

	/**
	 * Parametro nombre
	 * @return nombre
	 */
	public String getNombre() {
		return this.nombre;
	}

	/**
	 * Parametro
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * Parametro conPais
	 * @return codPais
	 */
	public String getCodPais() {
        return this.codPais;
    }

	/**
	 * Parametro codPais
	 * @param codPais
	 */
    public void setCodPais(String codPais) {
        this.codPais = codPais;
    }
    
    /**
     * Parametro pais
     * @return pais
     */
	public Pais getPais() {
		return this.pais;
	}

	/**
	 * Parametro
	 * @param pais
	 */
	public void setPais(Pais pais) {
		this.pais = pais;
	}

	/**
	 * Parametro listaConfig
	 * @return listaConfig
	 */
	public List<Configuracion> getListaConfig() {
		return this.listaConfig;
	}

	/**
	 * Parametro listaConfig
	 * @param listaConfig
	 */
	public void setListaConfig(List<Configuracion> listaConfig) {
		this.listaConfig = listaConfig;
	}

	/**
	 * Añade una configuracion a la lista
	 * @param config
	 * @return config
	 */
	public Configuracion addConfig(Configuracion config) {
		getListaConfig().add(config);
		config.setCiudad(this);

		return config;
	}

	/**
	 * Elimina una configuracion de la lista
	 * @param config
	 * @return config
	 */
	public Configuracion removeConfig(Configuracion config) {
		getListaConfig().remove(config);
		config.setCiudad(null);

		return config;
	}

}
