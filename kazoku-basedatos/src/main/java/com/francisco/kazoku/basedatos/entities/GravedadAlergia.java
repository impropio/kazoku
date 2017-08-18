package com.francisco.kazoku.basedatos.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the kz_gravedad database table.
 * 
 */
@Entity
@Table(name="kz_gravedad")
@NamedQuery(name="Gravedad.findAll", query="SELECT g FROM GravedadAlergia g")
public class GravedadAlergia extends com.francisco.kazoku.basedatos.core.impl.AbstractEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private byte id;

	@Column(name="gravedad_en")
	private String gravedadEN;

	@Column(name="gravedad_es")
	private String gravedadES;
	
	/**
     * Campo que no existe en la base de datos, se utiliza para guardar la gravedad en el idioma seleccionado por el usuario
     */
	@Transient
	private String gravedad;

	//bi-directional many-to-one association to Alergia
	@OneToMany(mappedBy="gravedadAlergia")
	private List<Alergia> listaAlergias;

	/**
	 * Constructor sin parametros
	 */
	public GravedadAlergia() {
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
	 * Parametro gravedadEN -> gravedad de la alergia en inglés
	 * @return gravedadEN
	 */
	public String getGravedadEN() {
		return this.gravedadEN;
	}

	/**
	 * Parametro gravedadEN -> gravedad de la alergia en inglés
	 * @param gravedadEN
	 */
	public void setGravedadEN(String gravedadEN) {
		this.gravedadEN = gravedadEN;
	}

	/**
	 * Parametro gravedadES -> gravedad de la alergia en español
	 * @return gravedadES
	 */
	public String getGravedadES() {
		return this.gravedadES;
	}

	/**
	 * Parametro gravedadES -> gravedad de la alergia en español
	 * @param gravedadES
	 */
	public void setGravedadES(String gravedadES) {
		this.gravedadES = gravedadES;
	}
	
	/**
	 * Parametro gravedad -> se rellena con la gravedad en el idioma del usuario
	 * @return gravedad
	 */
	public String getGravedad() {
        return this.gravedad;
    }

	/**
	 * Parametro gravedad -> se rellena con la gravedad en el idioma del usuario
	 * @param gravedad
	 */
    public void setGravedad(String gravedad) {
        this.gravedad = gravedad;
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
		alergia.setGravedadAlergia(this);

		return alergia;
	}

	/**
	 * Elimina una alergia de la lista
	 * @param alergia
	 * @return alergia
	 */
	public Alergia removeAlergia(Alergia alergia) {
		getListaAlergias().remove(alergia);
		alergia.setGravedadAlergia(null);

		return alergia;
	}

}
