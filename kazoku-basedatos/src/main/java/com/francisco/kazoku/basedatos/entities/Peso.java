package com.francisco.kazoku.basedatos.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the kz_peso database table.
 * 
 */
@Entity
@Table(name="kz_peso")
@NamedQuery(name="Peso.findAll", query="SELECT p FROM Peso p")
public class Peso extends com.francisco.kazoku.basedatos.core.impl.AbstractEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Lob
	private String comentario;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	private float peso;

	//bi-directional many-to-one association to PesoUsuario
	@ManyToOne
	@JoinColumn(name="peso_usuario", updatable=false, insertable=false)
	private PesoUsuario pesoUsuario;

	/**
	 * Constructor sin parametros
	 */
	public Peso() {
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
	 * Parametro comentario
	 * @return comentario
	 */
	public String getComentario() {
		return this.comentario;
	}

	/**
	 * Parametro comentario
	 * @param comentario
	 */
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	/**
	 * Parametro fecha
	 * @return fecha
	 */
	public Date getFecha() {
		return this.fecha;
	}

	/**
	 * Parametro fecha
	 * @param fecha
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	/**
	 * Parametro peso
	 * @return peso
	 */
	public float getPeso() {
		return this.peso;
	}

	/**
	 * Parametro peso
	 * @param peso
	 */
	public void setPeso(float peso) {
		this.peso = peso;
	}

	/**
	 * PArametro pesoUsuario
	 * @return pesoUsuario
	 */
	public PesoUsuario getPesoUsuario() {
		return this.pesoUsuario;
	}

	/**
	 * Parametro pesoUsuario
	 * @param pesoUsuario
	 */
	public void setPesoUsuario(PesoUsuario pesoUsuario) {
		this.pesoUsuario = pesoUsuario;
	}

}
