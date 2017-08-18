package com.francisco.kazoku.basedatos.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the kz_grupo_sang database table.
 * 
 */
@Entity
@Table(name="kz_grupo_sang")
@NamedQuery(name="GrupoSanguineo.findAll", query="SELECT g FROM GrupoSanguineo g")
public class GrupoSanguineo extends com.francisco.kazoku.basedatos.core.impl.AbstractEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String grupo;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="grupoSanguineo")
	private List<Usuario> listaUsuarios;

	/**
	 * Constructor con parametros
	 */
	public GrupoSanguineo() {
	}

	/**
	 * Parametro grupo
	 * @return grupo
	 */
	public String getGrupo() {
		return this.grupo;
	}

	/**
	 * Parametro grupo
	 * @param grupo
	 */
	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	/**
	 * Parametro listaUsuarios
	 * @return listaUsuarios
	 */
	public List<Usuario> getListaUsuarios() {
		return this.listaUsuarios;
	}

	/**
	 * Parametro listaUsuarios
	 * @param listaUsuarios
	 */
	public void setListaUsuarios(List<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	/**
	 * Añade un usuario a la lista
	 * @param usuario
	 * @return usuario
	 */
	public Usuario addUsuario(Usuario usuario) {
		getListaUsuarios().add(usuario);
		usuario.setGrupoSanguineo(this);

		return usuario;
	}

	/**
	 * Elimina un usuario de la lista
	 * @param usuario
	 * @return usuario
	 */
	public Usuario removeUsuario(Usuario usuario) {
		getListaUsuarios().remove(usuario);
		usuario.setGrupoSanguineo(null);

		return usuario;
	}

}
