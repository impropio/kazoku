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

	public GrupoSanguineo() {
	}

	public String getGrupo() {
		return this.grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public List<Usuario> getListaUsuarios() {
		return this.listaUsuarios;
	}

	public void setListaUsuarios(List<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	public Usuario addUsuario(Usuario usuario) {
		getListaUsuarios().add(usuario);
		usuario.setGrupoSanguineo(this);

		return usuario;
	}

	public Usuario removeUsuario(Usuario usuario) {
		getListaUsuarios().remove(usuario);
		usuario.setGrupoSanguineo(null);

		return usuario;
	}

}
