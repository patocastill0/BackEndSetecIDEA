package com.setec.mvc.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.io.Serializable;
import java.util.List;

public abstract class AbstractJpaDAO< T extends Serializable> {

    private Class< T > clazz;

    @PersistenceContext
    EntityManager entityManager;

    public final void setClazz( Class< T > clazzToSet ){
        this.clazz = clazzToSet;
    }

    public T findOne( long id ){
        T data =  entityManager.find(clazz,id);
       entityManager.close();
        return data;
    }
    public List< T > findAll(){
        List<T> lista = entityManager.createQuery("form" + clazz.getName()).getResultList();
        entityManager.close();
        return lista;
    }

    public void create( T entity ){
        entityManager.persist( entity );
        entityManager.close();
    }

    public T update( T entity ){
        T actualizar = entityManager.merge(entity);
        entityManager.close();
        return actualizar;
    }

    public void delete( T entity ){

        entityManager.remove( entity );
        entityManager.close();
    }
    public void deleteById( long entityId ){
        T entity = findOne( entityId );
        delete( entity );
    }
}
