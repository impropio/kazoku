package com.francisco.kazoku.basedatos.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the kz_peso_usuario database table.
 * 
 */
@Entity
@Table(name="kz_peso_usuario")
@NamedQuery(name="PesoUsuario.findAll", query="SELECT p FROM PesoUsuario p")
public class PesoUsuario extends com.francisco.kazoku.basedatos.core.impl.AbstractEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Lob
	private String comentario;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_obj")
	private Date fechaObjetivo;

	@Column(name="peso_obj")
	private float pesoObjetivo;

	private byte privado;

	//bi-directional many-to-one association to Peso
	@OneToMany(mappedBy="pesoUsuario")
	private List<Peso> listaPesos;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="usuario", updatable=false, insertable=false)
	private Usuario usuario;

	/**
	 * Constructor sin parametros
	 */
	public PesoUsuario() {
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
	 * Parametro fechaObjetivo
	 * @return fechaObjetivo
	 */
	public Date getFechaObjetivo() {
		return this.fechaObjetivo;
	}

	/**
	 * Parametro fechaObjetivo
	 * @param fechaObjetivo
	 */
	public void setFechaObj(Date fechaObjetivo) {
		this.fechaObjetivo = fechaObjetivo;
	}

	/**
	 * Parametro pesoObjetivo
	 * @return pesoObjetivo
	 */
	public float getPesoObjetivo() {
		return this.pesoObjetivo;
	}

	/**
	 * Parametro pesoObjetivo
	 * @param pesoObjetivo
	 */
	public void setPesoObjetivo(float pesoObjetivo) {
		this.pesoObjetivo = pesoObjetivo;
	}

	/**
	 * Parametro privado
	 * @return privado
	 */
	public byte getPrivado() {
		return this.privado;
	}

	/**
	 * Parametro privado
	 * @param privado
	 */
	public void setPrivado(byte privado) {
		this.privado = privado;
	}

	/**
	 * Parametro listaPesos
	 * @return listaPesos
	 */
	public List<Peso> getListaPesos() {
		return this.listaPesos;
	}

	/**
	 * Parametro listaPesos
	 * @param listaPesos
	 */
	public void setListaPesos(List<Peso> listaPesos) {
		this.listaPesos = listaPesos;
	}

	/**
	 * Añade un peso a la lista
	 * @param peso
	 * @return peso
	 */
	public Peso addPeso(Peso peso) {
		getListaPesos().add(peso);
		peso.setPesoUsuario(this);

		return peso;
	}

	/**
	 * Elimina un peso de la lista
	 * @param peso
	 * @return peso
	 */
	public Peso removePeso(Peso peso) {
		getListaPesos().remove(peso);
		peso.setPesoUsuario(null);

		return peso;
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
