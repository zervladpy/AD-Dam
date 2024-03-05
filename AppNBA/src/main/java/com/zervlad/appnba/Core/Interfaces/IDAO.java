package com.zervlad.appnba.Core.Interfaces;

import java.util.List;

public interface IDAO<T> {

    void create(T entity);

    T getById(int id);

    void update(T entity);

    void delete(T entity);

    void insertAll(List<T> entities);

    List<T> getAll();

    void drop();

}
