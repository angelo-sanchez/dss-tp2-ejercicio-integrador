package edu.unicen.tp2.repositories;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import org.hibernate.query.Query;

public class BaseJpaRepository<T, I extends Serializable> implements BaseRepository<T, I> {

    protected Session session;
    Class<T> entityClass;


    public BaseJpaRepository(Session session, Class<T> entityClass) {
        this.session = session;
        this.entityClass = entityClass;
    }

    @Override
    public T save(T entity) {
        
        Transaction tx = session.beginTransaction();
        
        session.persist(entity);
        
        tx.commit();

        return entity;
    }

    @Override
    public T findById(I id) {
        return session.get(entityClass, id);
    }

    @Override
    public void delete(T entity) {
        Transaction tx = session.beginTransaction();
        session.remove(entity);
        tx.commit();
    }

    @Override
    public List<T> findAll() {
        
        String hql = "FROM " + entityClass.getName();
        
        Query<T> query = session.createQuery(hql, entityClass);

        return query.getResultList();

    }
    
}
