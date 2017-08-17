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

	public GravedadAlergia() {
	}

	public byte getId() {
		return this.id;
	}

	public void setId(byte id) {
		this.id = id;
	}

	public String getGravedadEN() {
		return this.gravedadEN;
	}

	public void setGravedadEN(String gravedadEN) {
		this.gravedadEN = gravedadEN;
	}

	public String getGravedadES() {
		return this.gravedadES;
	}

	public void setGravedadES(String gravedadES) {
		this.gravedadES = gravedadES;
	}
	
	public String getGravedad() {
        return this.gravedad;
    }

    public void setGravedad(String gravedad) {
        this.gravedad = gravedad;
    }

	public List<Alergia> getListaAlergias() {
		return this.listaAlergias;
	}

	public void setListaAlergias(List<Alergia> listaAlergias) {
		this.listaAlergias = listaAlergias;
	}

	public Alergia addAlergia(Alergia alergia) {
		getListaAlergias().add(alergia);
		alergia.setGravedadAlergia(this);

		return alergia;
	}

	public Alergia removeAlergia(Alergia alergia) {
		getListaAlergias().remove(alergia);
		alergia.setGravedadAlergia(null);

		return alergia;
	}

}
