package com.francisco.kazoku.basedatos.interfaces;

import com.francisco.kazoku.basedatos.core.interfaces.AbstractDaoI;
import com.francisco.kazoku.basedatos.entities.Usuario;

/**
 * 
 * @author Francisco Moro <jfmoro@gmail.com>
 * @since 0.1
 *
 */
public interface UsuarioDaoI extends AbstractDaoI<Usuario>{
    
    /**
     * Recupera un usuario por su id
     * 
     * @param idUsuario
     * @return usuario
     */
    Usuario getUsuarioById(Integer idUsuario);
    
    /**
     * Crea un nuevo usuario en la base de datos
     * 
     * @param usuario
     * @return usuario
     */
    Usuario crearNuevoUsuario(Usuario usuario);
    
    /**
     * Actualiza un usuario en la base de datos
     * 
     * @param usuario
     * @return usuario
     */
    Usuario actualizarUsuario(Usuario usuario);
}
