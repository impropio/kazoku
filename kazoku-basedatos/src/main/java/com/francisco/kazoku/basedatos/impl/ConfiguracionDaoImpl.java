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
        
        Configuracion config = null;
                
        final CriteriaBuilder cb = getCriteriaBuilder();
        final CriteriaQuery<Configuracion> cq = cb.createQuery(getClase());
        final Root<Configuracion> root = cq.from(Configuracion.class);
        
        final List<Predicate> predicados = new ArrayList<>();
        
        predicados.add(cb.equal(root.<Integer> get("id"), 1));
        
        cq.where(predicados.toArray(new Predicate[]{}));
        
        try{
            config = lanzarCriteriaOneResult(cq);
        }catch(Exception e){
            if("No entity found for query".equals(e.getMessage())){
                return crearConfiguracionBasica();
            }
        }
        return config;
    }
    
    @Override
    public Configuracion actualizaConfiguracion(Configuracion config){
        return update(config);
    }
    
    public Configuracion crearConfiguracionBasica(){
        Configuracion conf = new Configuracion();
        conf.setId(1);
        return insert(conf);
    }

    @Override
    public Class<Configuracion> getClase(){
        return Configuracion.class;
    }
    
}
