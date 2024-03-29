package com.zervlad.tallerpaco.Core.DAO;

import com.zervlad.tallerpaco.Core.Entities.ITEntity;

import java.util.List;

/**
 * Base contract for DAOs
 * */
public interface IDAO<T extends ITEntity> {

    T getById(int id);
    List<T> getAll();
    void save(T entity);
    void saveMany(List<T> entities);
    void update(T entity);
    void delete(T entity);
    void deleteById(int id);
    void deleteAll();

}
