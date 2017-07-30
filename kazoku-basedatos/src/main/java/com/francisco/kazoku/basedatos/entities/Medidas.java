package com.francisco.kazoku.basedatos.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the kz_medidas database table.
 * 
 */
@Entity
@Table(name="kz_medidas")
@NamedQuery(name="Medidas.findAll", query="SELECT m FROM Medidas m")
public class Medidas extends com.francisco.kazoku.basedatos.core.impl.AbstractEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="medida_en")
	private String medidaEN;

	@Column(name="medida_es")
	private String medidaES;
	
	/**
     * Campo que no existe en la base de datos, se utiliza para guardar el sistema de medidas en el idioma seleccionado por el usuario
     */
	@Transient
	private String medida;

	//bi-directional many-to-one association to Configuracion
	@OneToMany(mappedBy="medidas")
	private List<Configuracion> listaConfig;

	public Medidas() {
	}

	public Medidas(int id, String medidas){
	    this.id = id;
	    this.medida = medidas;
	}
	
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMedidaEN() {
		return this.medidaEN;
	}

	public void setMedidaEN(String medidaEN) {
		this.medidaEN = medidaEN;
	}

	public String getMedidaES() {
		return this.medidaES;
	}

	public void setMedidaES(String medidaES) {
		this.medidaES = medidaES;
	}
	
	public String getMedida(){
	    return this.medida;
	}
	
	public void setMedida(String medida){
	    this.medida = medida;
	}

	public List<Configuracion> getListaConfig() {
		return this.listaConfig;
	}

	public void setListaConfig(List<Configuracion> listaConfig) {
		this.listaConfig = listaConfig;
	}

	public Configuracion addConfig(Configuracion config) {
		getListaConfig().add(config);
		config.setMedidas(this);

		return config;
	}

	public Configuracion removeConfig(Configuracion config) {
		getListaConfig().remove(config);
		config.setMedidas(null);

		return config;
	}

}
