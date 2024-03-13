package com.zervladpy.Dao;

import com.zervladpy.Utils.Interfaces.IDAO;
import com.zervladpy.Utils.Interfaces.IEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import lombok.Getter;

import java.util.List;

@Getter
public class DAO<T extends IEntity, ID> implements IDAO<T, ID> {

    private final EntityManager session;
    private final Class<T> entityClass;

    public DAO(EntityManager session, Class<T> entityClass) {
        this.session = session;
        this.entityClass = entityClass;
    }

    @Override
    public T getById(ID id) {
        String query = "select e from " + entityClass.getName() + " e where e.id = :id";
        TypedQuery<T> tQuery = session.createQuery(query, entityClass).setParameter("id", id);
        return tQuery.getSingleResult();
    }

    @Override
    public List<T> getAll() {
        String query = "select e from " + entityClass.getName() + " e";
        TypedQuery<T> tQuery = session.createQuery(query, entityClass);
        return tQuery.getResultList();
    }

    @Override
    public void save(T entity) {

        EntityTransaction transaction = session.getTransaction();

        transaction.begin();
        session.persist(entity);
        transaction.commit();
    }

    @Override
    public void saveMany(List<T> entities) {
        EntityTransaction transaction = session.getTransaction();

        transaction.begin();

        for (T entity: entities) {
            session.persist(entity);
        }

        transaction.commit();
    }

    @Override
    public void update(T entity) {

        EntityTransaction transaction = session.getTransaction();

        transaction.begin();
        session.merge(entity);
        transaction.commit();
    }

    @Override
    public void delete(T entity) {

        EntityTransaction transaction = session.getTransaction();

        transaction.begin();
        session.remove(entity);
        transaction.commit();
    }
}
