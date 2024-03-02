package com.zervlad.appnba.Core.Interfaces;

public interface DAO<T> {

    void create(T entity);

    T getById(int id);

    void update(T entity);

    void delete(T entity);

    void insertAll(T[] entities);

    T[] getAll();

    void drop();

}
