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

	public Configuracion() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getClimaApiId() {
		return this.climaApiId;
	}

	public void setClimaApiId(String climaApiId) {
		this.climaApiId = climaApiId;
	}

	public Integer getClimaNumeroDias() {
		return this.climaNumeroDias;
	}

	public void setClimaNumeroDias(Integer climaNumeroDias) {
		this.climaNumeroDias = climaNumeroDias;
	}

	public String getIdioma() {
		return this.idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public Ciudad getCiudad() {
		return this.ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}

	public Medidas getMedidas() {
		return this.medidas;
	}

	public void setMedidas(Medidas medidas) {
		this.medidas = medidas;
	}

}
