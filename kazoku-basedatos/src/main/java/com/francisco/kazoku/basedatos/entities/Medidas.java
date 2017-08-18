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

	/**
	 * Constructor sin parametros
	 */
	public Medidas() {
	}

	/**
	 * Constructor con parametros
	 * Se utiliza para poder crear el objeto cuando sólo se pide el parametro en el idioma del usuario
	 * 
	 * @param id
	 * @param medidas
	 */
	public Medidas(int id, String medidas){
	    this.id = id;
	    this.medida = medidas;
	}
	
	/**
	 * Parametro id
	 * @return id
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * PArametro id
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Parametro medidaEN
	 * @return medidaEN
	 */
	public String getMedidaEN() {
		return this.medidaEN;
	}

	/**
	 * Parametro medidaEN
	 * @param medidaEN
	 */
	public void setMedidaEN(String medidaEN) {
		this.medidaEN = medidaEN;
	}

	/**
	 * Parametro medidaES
	 * @return medidaES
	 */
	public String getMedidaES() {
		return this.medidaES;
	}

	/**
	 * Parametro medidaES
	 * @param medidaES
	 */
	public void setMedidaES(String medidaES) {
		this.medidaES = medidaES;
	}
	
	/**
	 * Parametro medida -> se utiliza para grabar las medidas en el idioma del usuario
	 * @return medida
	 */
	public String getMedida(){
	    return this.medida;
	}
	
	/**
	 * Parametro medida -> se utiliza para grabar las medidas en el idioma del usuario
	 * @param medida
	 */
	public void setMedida(String medida){
	    this.medida = medida;
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
		config.setMedidas(this);

		return config;
	}

	/**
	 * Elimina una configuracion de la lista
	 * @param config
	 * @return config
	 */
	public Configuracion removeConfig(Configuracion config) {
		getListaConfig().remove(config);
		config.setMedidas(null);

		return config;
	}

}
