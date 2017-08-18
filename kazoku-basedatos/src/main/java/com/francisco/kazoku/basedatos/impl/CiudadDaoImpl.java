package com.francisco.kazoku.basedatos.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.francisco.kazoku.basedatos.core.impl.AbstractDao;
import com.francisco.kazoku.basedatos.entities.Ciudad;
import com.francisco.kazoku.basedatos.interfaces.CiudadDaoI;

/**
 * 
 * @author Francisco Moro
 * @since 10/08/2017
 * @version 0.1
 *
 */
@Repository
public class CiudadDaoImpl extends AbstractDao<Ciudad> implements CiudadDaoI{

    /**
     * Recupera una ciudad de la base de datos por su id,
     * ordenada por nombre y con todos los parametros
     * 
     * @param idCiudad
     * 
     * @return ciudad -> Ciudad que cumple los requisitos
     */
    @Override
    public Ciudad getCiudadById(Integer idCiudad){
        
        final CriteriaBuilder cb = getCriteriaBuilder();
        final CriteriaQuery<Ciudad> cq = cb.createQuery(getClase());
        final Root<Ciudad> root = cq.from(Ciudad.class);
        final List<Predicate> predicados = new ArrayList<>();
        
        predicados.add(cb.equal(root.<Integer> get("id"), idCiudad));
        cq.orderBy(cb.asc(root.<String> get("nombre")));
        cq.where(predicados.toArray(new Predicate[] {}));
        
        Ciudad ciudad = lanzarCriteriaOneResult(cq);
        
        return ciudad;
    }
    
    /**
     * Recupera un numero determinado de ciudades, de un pais determinado y que alguna de sus palabras
     * comience por el testo introducido
     * 
     * @param codPais -> Codigo del país
     * @param texto -> Cadena de texto que se va a buscar en el nombre de la ciudad
     * @param limite -> Número de resultados máximos que se van a recuperar
     * 
     * @return ciudades -> Lista con las ciudades que cumplen los requisitos
     */
    @Override
    public List<Ciudad> getCiudadesPaisTextoLimite(String codPais, String texto, Integer limite){
        List<Ciudad> ciudades = new ArrayList<Ciudad>();
        
        final CriteriaBuilder cb = getCriteriaBuilder();
        final CriteriaQuery<Ciudad> cq = cb.createQuery(getClase());
        final Root<Ciudad> root = cq.from(Ciudad.class);
        
        final List<Predicate> predicados = new ArrayList<>();
        final List<Predicate> predicadosOr = new ArrayList<>();
        
        predicados.add(cb.equal(root.<String> get("codPais"), codPais));
        predicadosOr.add(cb.like(root.<String> get("nombre"), texto+"%"));
        predicadosOr.add(cb.like(root.<String> get("nombre"), "% "+texto+"%"));
        
        predicados.add(cb.or(predicadosOr.toArray(new Predicate[] {})));
        
        cq.where(predicados.toArray(new Predicate[] {}));
        cq.groupBy(root.get("nombre"));
        cq.orderBy(cb.asc(root.<String> get("nombre")));
        
        
        ciudades = lanzarCriteriaLimiteResultados(cq, limite);
        
        return ciudades;
    }
    
    /**
     * Recupera la clase del objeto
     */
    @Override
    public Class<Ciudad> getClase(){
        return Ciudad.class;
    }

}
