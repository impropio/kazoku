package com.francisco.kazoku.basedatos.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the kz_config database table.
 * 
 */
@Entity
@Table(name="kz_config")
@NamedQuery(name="Configuracion.findAll", query="SELECT c FROM Configuracion c")
public class Configuracion extends com.francisco.kazoku.basedatos.core.impl.AbstractEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="clima_api_id")
	private String climaApiId;

	@Column(name="clima_numero_dias")
	private Integer climaNumeroDias;

	@Column(name="idioma")
	private String idioma;

	//bi-directional many-to-one association to Ciudad
	@ManyToOne
	@JoinColumn(name="id_ciudad")
	private Ciudad ciudad;

	//bi-directional many-to-one association to Medidas
	@ManyToOne
	@JoinColumn(name="tipo_medidas")
	private Medidas medidas;

	/**
	 * Constructor sin parametros
	 */
	public Configuracion() {
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
	 * Parametro clipaApiId
	 * @return climaApiId
	 */
	public String getClimaApiId() {
		return this.climaApiId;
	}

	/**
	 * Parametro clipaApiId
	 * @param climaApiId
	 */
	public void setClimaApiId(String climaApiId) {
		this.climaApiId = climaApiId;
	}

	/**
	 * Parametro climaNumeroDias -> numero de dias que se obtendrán de la predicción
	 * @return climaNumeroDias
	 */
	public Integer getClimaNumeroDias() {
		return this.climaNumeroDias;
	}

	/**
	 * Parametro climaNumeroDias -> numero de dias que se obtendrán de la predicción
	 * @param climaNumeroDias
	 */
	public void setClimaNumeroDias(Integer climaNumeroDias) {
		this.climaNumeroDias = climaNumeroDias;
	}

	/**
	 * Parametro idioma
	 * @return idioma
	 */
	public String getIdioma() {
		return this.idioma;
	}

	/**
	 * Parametro idioma
	 * @param idioma
	 */
	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	/**
	 * Parametro ciudad
	 * @return ciudad
	 */
	public Ciudad getCiudad() {
		return this.ciudad;
	}

	/**
	 * Parametro ciudad
	 * @param ciudad
	 */
	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}

	/**
	 * Parametro medidas -> sistema de medicion que se va a utilizar
	 * @return medidas
	 */
	public Medidas getMedidas() {
		return this.medidas;
	}

	/**
	 * Parametro medidas -> sistema de medicion que se va a utilizar
	 * @param medidas
	 */
	public void setMedidas(Medidas medidas) {
		this.medidas = medidas;
	}

}
