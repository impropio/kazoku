package com.francisco.kazoku.basedatos.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.francisco.kazoku.basedatos.core.impl.AbstractDao;
import com.francisco.kazoku.basedatos.entities.Pais;
import com.francisco.kazoku.basedatos.interfaces.PaisDaoI;

@Repository
public class PaisDaoImpl extends AbstractDao<Pais> implements PaisDaoI{

    @Override
    public List<Pais> getPaises(String idioma){
        List<Pais> paises = new ArrayList<Pais>();
        
        final CriteriaBuilder cb = getCriteriaBuilder();
        final CriteriaQuery<Pais> cq = cb.createQuery(getClase());
        final Root<Pais> root = cq.from(Pais.class);
        
        cq.multiselect(root.<String> get("codigo"), root.<String> get("pais"+idioma).alias("pais"));
        cq.orderBy(cb.asc(root.<String> get("pais"+idioma)));
        
        paises = lanzarCriteria(cq);
        
        return paises;
    }
    
    @Override
    public Pais getPaisById(String idioma, String codPais){
        
        final CriteriaBuilder cb = getCriteriaBuilder();
        final CriteriaQuery<Pais> cq = cb.createQuery(getClase());
        final Root<Pais> root = cq.from(Pais.class);
        final List<Predicate> predicados = new ArrayList<>();
        
        predicados.add(cb.equal(root.<String> get("codigo"), codPais));
        cq.multiselect(root.<String> get("codigo"), root.<String> get("pais"+idioma).alias("pais"));
        cq.where(predicados.toArray(new Predicate[] {}));
        cq.orderBy(cb.asc(root.<String> get("pais"+idioma)));
        
        Pais pais = lanzarCriteriaOneResult(cq);
        
        return pais;
    }

    @Override
    public Class<Pais> getClase(){
        return Pais.class;
    }
    
}
