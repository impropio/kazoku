package com.francisco.kazoku.servicios.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.francisco.kazoku.basedatos.entities.Alergia;
import com.francisco.kazoku.basedatos.entities.Usuario;
import com.francisco.kazoku.basedatos.interfaces.AlergiaDaoI;
import com.francisco.kazoku.basedatos.interfaces.UsuarioDaoI;
import com.francisco.kazoku.servicios.dto.UsuarioDto;
import com.francisco.kazoku.servicios.interfaces.UsuarioServiceI;

/**
 * 
 * @author Francisco Moro <jfmoro@gmail.com>
 * @since 0.1
 *
 */
@Service
public class UsuarioServiceImpl implements UsuarioServiceI{
    
    @Autowired
    private UsuarioDaoI usuarioDao;
    
    @Autowired
    private AlergiaDaoI alergiaDao;
    
    /**
     * Recupera un usuario por su id
     * 
     * @param idUsuario
     * @return usuarioDto
     */
    @Override
    public UsuarioDto getUsuarioById(Integer idUsuario){
        UsuarioDto usuarioDto = new UsuarioDto();
        Usuario usuario = usuarioDao.getUsuarioById(idUsuario);
        return usuarioDto.entityToDto(usuario);
    }

    /**
     * Recupera la lista de todos los usuarios de la aplicación
     * 
     * @return lista de usuarioDto
     */
    @Override
    public List<UsuarioDto> getUsuarios(){
        List<UsuarioDto> listaUsuariosDto = new ArrayList<UsuarioDto>();
        List<Usuario> listaUsuarios = usuarioDao.getAll();
        
        for(Usuario usuario : listaUsuarios){
            UsuarioDto usuarioDto = new UsuarioDto();
            listaUsuariosDto.add(usuarioDto.entityToDto(usuario));
        }
        
        return listaUsuariosDto;
    }

    /**
     * Actualiza un usuario en la base de datos o le crea si no existe
     * 
     * @param usuarioDto
     * @return usuarioDto
     */
    @Override
    @Transactional
    public UsuarioDto actualizarUsuario(UsuarioDto usuarioDto){
        UsuarioDto usuarioDtoActualizado = new UsuarioDto();
        Usuario usuario = null;
        Usuario usaurioActualizado = null;
        
        // Se recupera el usuario
        if(usuarioDto.getId() == 0){
            usuario = usuarioDto.dtoToEntity(usuarioDto);
        }else{
            usuario = usuarioDao.getUsuarioById(usuarioDto.getId());
            usuario.setNombre(usuarioDto.getNombre());
            usuario.setClave(usuarioDto.getClave());
            usuario.setFechaNacimiento(usuarioDto.getFechaNacimiento());
            usuario.setDni(usuarioDto.getDni());
            usuario.setPasaporte(usuarioDto.getPasaporte());
            usuario.setSeguridadSocial(usuarioDto.getSegSocial());
            usuario.setGrupoSanguineo(usuarioDto.getGrupoSanguineo());
        }
        
        // Si el usuario va a utilizar contraseña se indica
        if(!"".equals(usuarioDto.getClave())) usuario.setUsaClave((byte) 1);
        
//        // Se graba la lista de alergias
//        if(!"".equals(usuarioDto.getCodigoAlergias())){
//            List<Alergia> listaAlergias = new ArrayList<Alergia>();
//            String[] listaCodigosAlergia = usuarioDto.getCodigoAlergias().split(",");
//            for(String codigoAlergia : listaCodigosAlergia){
//                Alergia alergia = alergiaDao.getAlergiaById(Integer.parseInt(codigoAlergia));
//                listaAlergias.add(alergia);
//            }
//            usuario.setListaAlergias(listaAlergias);
//        }
        
        // Se actualiza o crea el usuario
        if(usuarioDto.getId() == 0){
            usaurioActualizado = usuarioDao.crearNuevoUsuario(usuario);
        }else{
            usaurioActualizado = usuarioDao.actualizarUsuario(usuario);
        }
        
        return usuarioDtoActualizado.entityToDto(usaurioActualizado);
    }
    
}
