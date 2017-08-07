package com.francisco.kazoku.basedatos.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.francisco.kazoku.basedatos.core.impl.AbstractDao;
import com.francisco.kazoku.basedatos.entities.Medidas;
import com.francisco.kazoku.basedatos.interfaces.MedidasDaoI;

@Repository
public class MedidasDaoImpl extends AbstractDao<Medidas> implements MedidasDaoI{

    @Override
    public List<Medidas> getMedidasIdioma(String idioma){
        List<Medidas> medidas = new ArrayList<Medidas>();
        
        final CriteriaBuilder cb = getCriteriaBuilder();
        final CriteriaQuery<Medidas> cq = cb.createQuery(getClase());
        final Root<Medidas> root = cq.from(Medidas.class);
        
        cq.multiselect(root.get("id"), root.get("medida"+idioma).alias("medida"));
        
        medidas = lanzarCriteria(cq);
        
        return medidas;
    }
    
    @Override
    public Medidas getMedidasById(Integer id){
        final CriteriaBuilder cb = getCriteriaBuilder();
        final CriteriaQuery<Medidas> cq = cb.createQuery(getClase());
        final Root<Medidas> root = cq.from(Medidas.class);
        
        final List<Predicate> predicados = new ArrayList<>();
        
        predicados.add(cb.equal(root.<Integer> get("id"), id));
        
        cq.where(predicados.toArray(new Predicate[]{}));
        Medidas medida = lanzarCriteriaOneResult(cq);
        
        return medida;
    }

    @Override
    public Class<Medidas> getClase(){
        return Medidas.class;
    }
    
}
