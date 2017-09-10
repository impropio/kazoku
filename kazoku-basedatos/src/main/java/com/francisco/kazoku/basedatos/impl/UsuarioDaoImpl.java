package com.francisco.kazoku.basedatos.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Fetch;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.francisco.kazoku.basedatos.core.impl.AbstractDao;
import com.francisco.kazoku.basedatos.entities.Alergia;
import com.francisco.kazoku.basedatos.entities.Usuario;
import com.francisco.kazoku.basedatos.interfaces.UsuarioDaoI;

/**
 * 
 * @author Francisco Moro <jfmoro@gmail.com>
 * @since 0.1
 *
 */
@Repository
public class UsuarioDaoImpl extends AbstractDao<Usuario> implements UsuarioDaoI{

    /**
     * Recupera un usuario por su id
     * 
     * @param idUsuario
     * @return usuario
     */
    @Override
    public Usuario getUsuarioById(Integer idUsuario){
        final CriteriaBuilder cb = getCriteriaBuilder();
        final CriteriaQuery<Usuario> cq = cb.createQuery(getClase());
        final Root<Usuario> root = cq.from(Usuario.class);
        
        final Fetch<Usuario, Alergia> rootAlergia = root.fetch("listaAlergias", JoinType.LEFT);
        
        final List<Predicate> predicados = new ArrayList<>();
        
        predicados.add(cb.equal(root.<Integer> get("id"), idUsuario));
        
        cq.where(predicados.toArray(new Predicate[]{}));
        Usuario usuario = lanzarCriteriaOneResult(cq);
        
        return usuario;
    }
    
    /**
     * Crea un nuevo usuario en la base de datos
     * 
     * @param usuario
     * @return usuario
     */
    @Override
    public Usuario crearNuevoUsuario(Usuario usuario) {
        return insert(usuario);
    }

    /**
     * Actualiza un usuario en la base de datos
     * 
     * @param usuario
     * @return usuario
     */
    @Override
    public Usuario actualizarUsuario(Usuario usuario) {
        return update(usuario);
    }

    /**
     * Recupera la clase del objeto
     */
    @Override
    public Class<Usuario> getClase() {
        return Usuario.class;
    }

}
