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
	private String paisES;
	
	/**
	 * Campo que no existe en la base de datos, se utiliza para guardar el país en el idioma seleccionado por el usuario
	 */
	@Transient
	private String pais;

	//bi-directional many-to-one association to Ciudad
	@OneToMany(mappedBy="pais")
	private List<Ciudad> listaCiudades;

	/**
	 * Constructor sin parametros
	 */
	public Pais() {
	}

	/**
	 * Construccion con parametros
	 * Se utiliza para poder crear el objeto cuando sólo se pide el parametro en el idioma del usuario
	 * 
	 * @param codigo
	 * @param pais
	 */
	public Pais(String codigo, String pais){
	    this.codigo = codigo;
	    this.pais = pais;
	}
	
	/**
	 * Parametro codigo
	 * @return codigo
	 */
	public String getCodigo() {
		return this.codigo;
	}

	/**
	 * Parametro codigo
	 * @param codigo
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * Parametro paisES
	 * @return paisES
	 */
	public String getPaisES() {
		return this.paisES;
	}

	/**
	 * Parametro paisES
	 * @param paisES
	 */
	public void setPaisES(String paisES) {
		this.paisES = paisES;
	}
	
	/**
	 * Parametro pais -> se utiliza para grabar el pais en el idioma del usuario
	 * @return
	 */
	public String getPais() {
        return this.pais;
    }

	/**
	 * Parametro pais -> se utiliza para grabar el pais en el idioma del usuario
	 * @param pais
	 */
    public void setPais(String pais) {
        this.pais = pais;
    }

    /**
     * Parametro listaCiudades
     * @return listaCiudades
     */
	public List<Ciudad> getListaCiudades() {
		return this.listaCiudades;
	}

	/**
	 * Parametro listaCiudades
	 * @param listaCiudades
	 */
	public void setListaCiudades(List<Ciudad> listaCiudades) {
		this.listaCiudades = listaCiudades;
	}

	/**
	 * Añade una ciudad a la lista
	 * @param ciudad
	 * @return ciudad
	 */
	public Ciudad addCiudad(Ciudad ciudad) {
		getListaCiudades().add(ciudad);
		ciudad.setPais(this);

		return ciudad;
	}

	/**
	 * Elimina una ciudad de la lista
	 * @param ciudad
	 * @return ciudad
	 */
	public Ciudad removeCiudad(Ciudad ciudad) {
		getListaCiudades().remove(ciudad);
		ciudad.setPais(null);

		return ciudad;
	}

}
