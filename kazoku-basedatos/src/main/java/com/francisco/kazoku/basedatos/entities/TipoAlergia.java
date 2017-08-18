package com.francisco.kazoku.basedatos.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the kz_tipo database table.
 * 
 */
@Entity
@Table(name="kz_tipo_alergia")
@NamedQuery(name="TipoAlergia.findAll", query="SELECT t FROM TipoAlergia t")
public class TipoAlergia extends com.francisco.kazoku.basedatos.core.impl.AbstractEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private byte id;

	@Column(name="tipo_en")
	private String tipoEN;

	@Column(name="tipo_es")
	private String tipoES;
	
	/**
     * Campo que no existe en la base de datos, se utiliza para guardar el tipo de alergia en el idioma seleccionado por el usuario
     */
	@Transient
	private String tipoAlergia;

	//bi-directional many-to-one association to Alergia
	@OneToMany(mappedBy="tipoAlergia")
	private List<Alergia> listaAlergias;

	/**
	 * Constructor sin parametros
	 */
	public TipoAlergia() {
	}

	/**
	 * Parametro id
	 * @return id
	 */
	public byte getId() {
		return this.id;
	}

	/**
	 * Parametro id
	 * @param id
	 */
	public void setId(byte id) {
		this.id = id;
	}

	/**
	 * Parametro tipoEN
	 * @return tipoEN
	 */
	public String getTipoEN() {
		return this.tipoEN;
	}

	/**
	 * Parametro tipoEN
	 * @param tipoEN
	 */
	public void setTipoEN(String tipoEN) {
		this.tipoEN = tipoEN;
	}

	/**
	 * Parametro tipoES
	 * @return tipoES
	 */
	public String getTipoES() {
		return this.tipoES;
	}

	/**
	 * Parametro tipoES
	 * @param tipoES
	 */
	public void setTipoES(String tipoES) {
		this.tipoES = tipoES;
	}
	
	/**
	 * Parametro tipoAlergia -> se utiliza para grabar el tipo de alergia en el idioma del usuario
	 * @return tipoAlergia
	 */
	public String getTipoAlergia() {
        return this.tipoAlergia;
    }

	/**
	 * Parametro tipoAlergia -> se utiliza para grabar el tipo de alergia en el idioma del usuario
	 * @param tipoAlergia
	 */
    public void setTipoAlergia(String tipoAlergia) {
        this.tipoAlergia = tipoAlergia;
    }

    /**
     * Parametro listaAlergias
     * @return listaAlergias
     */
	public List<Alergia> getListaAlergias() {
		return this.listaAlergias;
	}

	/**
	 * Parametro listaAlergias
	 * @param listaAlergias
	 */
	public void setListaAlergias(List<Alergia> listaAlergias) {
		this.listaAlergias = listaAlergias;
	}

	/**
	 * Añade una alergia a la lista
	 * @param alergia
	 * @return alergia
	 */
	public Alergia addAlergia(Alergia alergia) {
		getListaAlergias().add(alergia);
		alergia.setTipoAlergia(this);

		return alergia;
	}

	/**
	 * Elimina una alergia de la lista
	 * @param alergia
	 * @return alergia
	 */
	public Alergia removeAlergia(Alergia alergia) {
		getListaAlergias().remove(alergia);
		alergia.setTipoAlergia(null);

		return alergia;
	}

}
