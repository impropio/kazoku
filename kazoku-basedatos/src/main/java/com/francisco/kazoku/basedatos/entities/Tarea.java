package com.francisco.kazoku.basedatos.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the kz_tareas database table.
 * 
 */
@Entity
@Table(name="kz_tareas")
@NamedQuery(name="Tarea.findAll", query="SELECT t FROM Tarea t")
public class Tarea extends com.francisco.kazoku.basedatos.core.impl.AbstractEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Lob
	private String descripcion;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	private byte privada;

	private String titulo;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="usuario", updatable=false, insertable=false)
	private Usuario usuario;

	/**
	 * Constructor sin parametros
	 */
	public Tarea() {
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
	 * Parametro descripcion
	 * @return descripcion
	 */
	public String getDescripcion() {
		return this.descripcion;
	}

	/**
	 * Parametro descripcion
	 * @param descripcion
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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
	 * Parametro privada
	 * @return privada
	 */
	public byte getPrivada() {
		return this.privada;
	}

	/**
	 * Parametro privada
	 * @param privada
	 */
	public void setPrivada(byte privada) {
		this.privada = privada;
	}

	/**
	 * Parametro titulo
	 * @return titulo
	 */
	public String getTitulo() {
		return this.titulo;
	}

	/**
	 * Parametro titulo
	 * @param titulo
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * Parametro usuario
	 * @return usuario
	 */
	public Usuario getUsuario() {
		return this.usuario;
	}

	/**
	 * Parametro usuario
	 * @param usuario
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
