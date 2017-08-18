package com.francisco.kazoku.basedatos.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the kz_garantia database table.
 * 
 */
@Entity
@Table(name="kz_garantia")
@NamedQuery(name="Garantia.findAll", query="SELECT g FROM Garantia g")
public class Garantia extends com.francisco.kazoku.basedatos.core.impl.AbstractEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String concepto;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_compra")
	private Date fechaCompra;

	private String imagen;

	private float importe;

	private String tienda;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="usuario", updatable=false, insertable=false)
	private Usuario usuario;

	/**
	 * Constructor con parametros
	 */
	public Garantia() {
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
	 * Parametro concepto
	 * @return concepto
	 */
	public String getConcepto() {
		return this.concepto;
	}

	/**
	 * Parametro concepto
	 * @param concepto
	 */
	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}

	/**
	 * Parametro fechaCompra
	 * @return fechaCompra
	 */
	public Date getFechaCompra() {
		return this.fechaCompra;
	}

	/**
	 * Parametro fechaCompra
	 * @param fechaCompra
	 */
	public void setFechaCompra(Date fechaCompra) {
		this.fechaCompra = fechaCompra;
	}

	/**
	 * Parametro imagen -> ruta del fiechero de imagen del usuario
	 * @return imagen
	 */
	public String getImagen() {
		return this.imagen;
	}

	/**
	 * Parametro imagen
	 * @param imagen
	 */
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	/**
	 * Parametro importe
	 * @return importe
	 */
	public float getImporte() {
		return this.importe;
	}

	/**
	 * Parametro importe
	 * @param importe
	 */
	public void setImporte(float importe) {
		this.importe = importe;
	}

	/**
	 * Parametro tienda
	 * @return tienda
	 */
	public String getTienda() {
		return this.tienda;
	}

	/**
	 * Parametro tienda
	 * @param tienda
	 */
	public void setTienda(String tienda) {
		this.tienda = tienda;
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
