package com.francisco.kazoku.basedatos.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.francisco.kazoku.basedatos.core.impl.AbstractDao;
import com.francisco.kazoku.basedatos.entities.Configuracion;
import com.francisco.kazoku.basedatos.interfaces.ConfiguracionDaoI;

@Repository
public class ConfiguracionDaoImpl extends AbstractDao<Configuracion> implements ConfiguracionDaoI{

    @Override
    public Configuracion getConfiguracion(){
        final CriteriaBuilder cb = getCriteriaBuilder();
        final CriteriaQuery<Configuracion> cq = cb.createQuery(getClase());
        final Root<Configuracion> root = cq.from(Configuracion.class);
        
        final List<Predicate> predicados = new ArrayList<>();
        
        predicados.add(cb.equal(root.<Integer> get("id"), 1));
        
        cq.where(predicados.toArray(new Predicate[]{}));
        Configuracion config = lanzarCriteriaOneResult(cq);
        
        return config;
    }

    @Override
    public Class<Configuracion> getClase(){
        return Configuracion.class;
    }
    
}
