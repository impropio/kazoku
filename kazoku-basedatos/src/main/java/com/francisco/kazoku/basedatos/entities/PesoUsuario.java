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

	public PesoUsuario() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getComentario() {
		return this.comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Date getFechaObjetivo() {
		return this.fechaObjetivo;
	}

	public void setFechaObj(Date fechaObjetivo) {
		this.fechaObjetivo = fechaObjetivo;
	}

	public float getPesoObjetivo() {
		return this.pesoObjetivo;
	}

	public void setPesoObjetivo(float pesoObjetivo) {
		this.pesoObjetivo = pesoObjetivo;
	}

	public byte getPrivado() {
		return this.privado;
	}

	public void setPrivado(byte privado) {
		this.privado = privado;
	}

	public List<Peso> getListaPesos() {
		return this.listaPesos;
	}

	public void setListaPesos(List<Peso> listaPesos) {
		this.listaPesos = listaPesos;
	}

	public Peso addPeso(Peso peso) {
		getListaPesos().add(peso);
		peso.setPesoUsuario(this);

		return peso;
	}

	public Peso removePeso(Peso peso) {
		getListaPesos().remove(peso);
		peso.setPesoUsuario(null);

		return peso;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
