package com.francisco.kazoku.basedatos.impl;

import com.francisco.kazoku.basedatos.core.impl.AbstractDao;
import com.francisco.kazoku.basedatos.entities.Usuario;
import com.francisco.kazoku.basedatos.interfaces.UsuarioDaoI;

public class UsuarioDaoImpl extends AbstractDao<Usuario> implements UsuarioDaoI{

    @Override
    public Usuario crearNuevoUsuario(Usuario usuario) {
        return insert(usuario);
    }

    @Override
    public Usuario actualizarUsuario(Usuario usuario) {
        return update(usuario);
    }

    @Override
    public Class<Usuario> getClase() {
        return Usuario.class;
    }

}
