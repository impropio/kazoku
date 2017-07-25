package com.francisco.kazoku.basedatos.core.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.francisco.kazoku.basedatos.core.interfaces.AbstractDaoI;

public abstract class AbstractDao <E extends AbstractEntity> implements AbstractDaoI<E>{
    
    /** The sec map. */
    private static Map<String, Long> secMap = new HashMap<String, Long>();
    
    /** The entity manager. */
    protected EntityManager entityManager;
    
    /**
     * Borra un objeto de la base de datos
     * 
     * @param item
     */
    @Override
    public void delete(final E item) {
        if (item == null) {
            throw new NullPointerException();
        }
        try {
            this.entityManager.remove(item);
        } catch (final Exception e) {
            throw e;
        }
    }
    
    /**
     * Borra un objeto de la base de datos
     * 
     * @param id
     */
    @Override
    public void delete(final Object id) {
        if (id == null) {
            throw new NullPointerException();
        }
        try {
            delete(getById(id));
        } catch (final Exception e) {
            throw e;
        }
    }
    
    /**
     * Limpia la cache de la base de datos
     */
    @Override
    public void flush() {
        try {
            this.entityManager.flush();
        } catch (final Exception e) {
            throw e;
        }
    }
    
    /**
     * Recupera todos los objetos de la base de datos
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    public List<E> getAll() {
        try {
            final CriteriaQuery cq = this.entityManager.getCriteriaBuilder().createQuery();
            cq.select(cq.from(getClase()));
            return this.entityManager.createQuery(cq).getResultList();
        } catch (final Exception e) {
            throw e;
        }
    }
    
    /**
     * Recupera todos los objetos de la base de datos con el orden establecido
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    public List<E> getAll(final String fieldOrder) {
        try {
            final CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
            final CriteriaQuery cq = cb.createQuery();
            final Root<E> root = cq.from(getClase());
            cq.select(root);
            cq.orderBy(cb.asc(root.<String> get(fieldOrder)));
            return lanzarCriteria(cq);
        } catch (final Exception e) {
            throw e;
        }
    }
    
    /**
     * Recupera un objeto de la base de datos a traves de su ID
     * 
     * @param id
     */
    @Override
    public E getById(final Object id) {
        if (id == null) {
            throw new NullPointerException();
        }
        try {
            return this.entityManager.find(getClase(), id);
        } catch (final Exception e) {
            throw e;
        }
    }
    
    /**
     * Recupera un objeto de la base de datos por su ID indicando el nombre del campo ID
     * 
     * @param id
     * @param nombreID
     */
    @Override
    public E getById(final String id, final String nombreID) {
        if (id == null || nombreID == null) {
            throw new NullPointerException();
        }
        try {
            final CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
            final CriteriaQuery<E> cq = cb.createQuery(getClase());
            final Root<E> foo = cq.from(getClase());
            cq.where(cb.equal(cb.trim(foo.<String> get(nombreID)), id.trim()));
            final TypedQuery<E> q = this.entityManager.createQuery(cq);
            final E result = q.getSingleResult();
            flush();
            return result;
        } catch (final Exception e) {
            throw e;
        }
    }
    
    /**
     * Gets the clase.
     *
     * @return the clase
     */
    public abstract Class<E> getClase();
    
    /**
     * Gets CriteriaBuilder
     */
    @Override
    public CriteriaBuilder getCriteriaBuilder() {
        try {
            return this.entityManager.getCriteriaBuilder();
        } catch (final Exception e) {
            throw e;
        }
    }
    
    /**
     * Inserta un objeto en la base de datos
     * 
     * @param item
     */
    @Override
    public E insert(final E item) {
        if (item == null) {
            throw new NullPointerException();
        }
        try {
            this.entityManager.persist(item);
        } catch (final Exception e) {
            throw e;
        }
        return item;
    }
    
    /**
     * Lanza la consulta para recuperar una lista de resultados
     * 
     * @param cq
     */
    @Override
    public List<E> lanzarCriteria(final CriteriaQuery<E> cq) {
        try {
            List<E> results;
            final TypedQuery<E> q = this.entityManager.createQuery(cq);
            
            results = q.getResultList();
            return results;
        } catch (final Exception e) {
            throw e;
        }
    }
    
    /**
     * Lanzar la consulta para recuperar un único resultado
     * 
     * @param cq
     */
    @Override
    public E lanzarCriteriaOneResult(final CriteriaQuery<E> cq) {
        try {
            E result;
            final TypedQuery<E> q = this.entityManager.createQuery(cq);
            result = q.getSingleResult();
            return result;
        } catch (final Exception e) {
            throw e;
        }
    }
    
    /**
     * 
     * @param entityManager
     */
    @PersistenceContext
    public void setEntityManager(final EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    /**
     * Actualiza un objeto en la base de datos
     * 
     * @param item
     */
    @Override
    public E update(final E item) {
        if (item == null) {
            throw new NullPointerException();
        }
        try {
            this.entityManager.merge(item);
            return item;
        } catch (final Exception e) {
            throw e;
        }
    }
    
    /**
     * Recoge el id maximo mas 1.
     *
     * @param idName
     * @return the long
     */
    @Override
    public synchronized Long nextId(final String idName) {
        try {
            final CriteriaBuilder cb = getCriteriaBuilder();
            final CriteriaQuery<Tuple> cq = cb.createTupleQuery();
            final Root<E> root = cq.from(getClase());
            
            cq.select(cb.tuple(cb.max(root.<Long> get(idName)).alias("MAXID")));
            
            final Tuple results = this.entityManager.createQuery(cq).getSingleResult();
            
            final Object result = results.get("MAXID");
            
            Long maximo = 1L;
            if (result != null) {
                if (result instanceof Long) {
                    maximo = (Long) result + 1;
                } else if (result instanceof String) {
                    maximo = Long.parseLong(result.toString()) + 1;
                }
            }
            
            // miramos si ya tenemos registrada una secuencia para la clase
            // actual.
            Long sec = secMap.get(getClase().getSimpleName());
            if (sec != null && sec >= maximo) {
                maximo = sec++;
            }
            
            // guardamos la secuencia actual en el mapa de secuencias
            secMap.put(getClase().getSimpleName(), maximo);
            
            return maximo;
        } catch (final Exception e) {
            throw e;
        }
    }
}
