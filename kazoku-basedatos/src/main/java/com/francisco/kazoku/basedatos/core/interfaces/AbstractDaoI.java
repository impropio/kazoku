package com.francisco.kazoku.basedatos.core.interfaces;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import com.francisco.kazoku.basedatos.core.impl.AbstractEntity;

public interface AbstractDaoI <E extends AbstractEntity>{
    
    /**
     * Borra la entity en la BBDD.
     *
     * @param item
     *            the item
     */
    void delete(E item);
    
    /**
     * Borra la entity con ese id en la BBDD.
     *
     * @param id
     *            the id
     */
    void delete(Object id);
    
    /**
     * Flush.
     */
    void flush();
    
    /**
     * Devuelve una lista con todas la entities de bbdd de tipo E.
     *
     * @return the all
     */
    List<E> getAll();
    
    /**
     * Gets the all.
     *
     * @param fieldOrder
     *            the field order
     * @return the all
     */
    List<E> getAll(String fieldOrder);
    
    /**
     * Devuelve la entity a partir del id.
     *
     * @param id
     *            the id
     * @return the by id
     */
    E getById(Object id);
    
    /**
     * Gets the by id.
     *
     * @param id
     *            the id
     * @param idNameInEntity
     *            the id name in entity
     * @return the by id
     */
    E getById(String id, String idNameInEntity);
    
    /**
     * Devuelve el criteriaBuilder.
     *
     * @return the criteria builder
     */
    CriteriaBuilder getCriteriaBuilder();
    
    /**
     * Inserta en BBDD el objeto item.
     *
     * @param item
     *            the item
     * @return the e
     */
    E insert(E item);
    
    /**
     * Lanza el criteria preparado contra la BBDD.
     *
     * @param cq
     *            the cq
     * @return the list
     */
    List<E> lanzarCriteria(CriteriaQuery<E> cq);
    
    /**
     * Actualiza en BBDD el objeto item.
     *
     * @param item
     *            the item
     * @return the e
     */
    E update(E item);
    
    /**
     * Next id.
     *
     * @param idNameEntity
     *            the id name entity
     * @return the long
     */
    Long nextId(String idNameEntity);
    
    /**
     * Lanzar criteria one result.
     *
     * @param cq
     *            the cq
     * @return the e
     */
    E lanzarCriteriaOneResult(CriteriaQuery<E> cq);
    
    /**
     * Lanzar criteria con limite de resultados
     * 
     * @param cq
     * @param limite
     * @return the e
     */
    List<E> lanzarCriteriaLimiteResultados(CriteriaQuery<E> cq, Integer limite);
}
