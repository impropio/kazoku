package com.francisco.kazoku.basedatos.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.francisco.kazoku.basedatos.core.impl.AbstractDao;
import com.francisco.kazoku.basedatos.entities.Alergia;
import com.francisco.kazoku.basedatos.interfaces.AlergiaDaoI;

/**
 * 
 * @author Francisco Moro <jfmoro@gmail.com>
 * @since 0.1
 *
 */
@Repository
public class AlergiaDaoImpl extends AbstractDao<Alergia> implements AlergiaDaoI{
    
    /**
     * Recupera una alergia por su id
     * 
     * @param id
     * @return Alergia
     */
    @Override
    public Alergia getAlergiaById(Integer id){
        final CriteriaBuilder cb = getCriteriaBuilder();
        final CriteriaQuery<Alergia> cq = cb.createQuery(getClase());
        final Root<Alergia> root = cq.from(Alergia.class);
        
        final List<Predicate> predicados = new ArrayList<>();
        
        predicados.add(cb.equal(root.<Integer> get("id"), id));
        
        cq.where(predicados.toArray(new Predicate[]{}));
        Alergia alergia = lanzarCriteriaOneResult(cq);
        
        return alergia;
    }
    
    /**
     * Recupera la clase del objeto
     */
    @Override
    public Class<Alergia> getClase(){
        return Alergia.class;
    }
    
}
