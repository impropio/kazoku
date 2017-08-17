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

@Repository
public class CiudadDaoImpl extends AbstractDao<Ciudad> implements CiudadDaoI{

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
    
    @Override
    public Class<Ciudad> getClase(){
        return Ciudad.class;
    }

}
