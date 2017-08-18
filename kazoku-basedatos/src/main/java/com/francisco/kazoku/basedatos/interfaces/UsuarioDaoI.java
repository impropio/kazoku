package com.francisco.kazoku.basedatos.interfaces;

import com.francisco.kazoku.basedatos.core.interfaces.AbstractDaoI;
import com.francisco.kazoku.basedatos.entities.Usuario;

public interface UsuarioDaoI extends AbstractDaoI<Usuario>{
    
    Usuario crearNuevoUsuario(Usuario usuario);
    
    Usuario actualizarUsuario(Usuario usuario);
}
