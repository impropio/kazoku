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

/**
 * 
 * @author Francisco Moro <jfmoro@gmail.com>
 * @since 0.1
 *
 */
@Repository
public class ConfiguracionDaoImpl extends AbstractDao<Configuracion> implements ConfiguracionDaoI{

    /**
     * Recupera la configuración general de la aplicación, como es la configuración general no es
     * necesario pasar el id ya que siempre será 1
     * 
     * @return config -> Configuración general de la aplicación
     */
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
    
    /**
     * Actualiza la configuración general de la aplicación
     * 
     * @param config
     * @return config -> con los parametros actualizados
     */
    @Override
    public Configuracion actualizaConfiguracion(Configuracion config){
        return update(config);
    }
    
    /**
     * En caso de no existir datos de la configuración en la base de datos crea el campo
     * para que el usuario la pueda personalizar
     * 
     * @return config -> Configuración básica de inicio
     */
    public Configuracion crearConfiguracionBasica(){
        Configuracion conf = new Configuracion();
        conf.setId(1);
        return insert(conf);
    }

    /**
     * Recupera la clase del objeto
     */
    @Override
    public Class<Configuracion> getClase(){
        return Configuracion.class;
    }
    
}
