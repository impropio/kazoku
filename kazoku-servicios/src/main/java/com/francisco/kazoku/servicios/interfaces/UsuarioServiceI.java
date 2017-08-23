package com.francisco.kazoku.servicios.interfaces;

import java.util.List;

import com.francisco.kazoku.servicios.dto.UsuarioDto;

/**
 * 
 * @author Francisco Moro <jfmoro@gmail.com>
 * @since 0.1
 *
 */
public interface UsuarioServiceI{
    
    /**
     * Recupera un usuario por su id
     * 
     * @param idUsuario
     * @return UsuarioDto
     */
    UsuarioDto getUsuarioById(Integer idUsuario);
    
    /**
     * Recupera toda la lista de usuarios
     * 
     * @return listaUsuariosDto
     */
    List<UsuarioDto> getUsuarios();
    
    /**
     * Actualiza los datos de un usuario o le crea si no existe
     * 
     * @param usuario
     * @return usuario
     */
    UsuarioDto actualizarUsuario(UsuarioDto usuario);
}
