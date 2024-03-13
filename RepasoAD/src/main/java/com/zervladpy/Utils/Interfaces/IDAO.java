package com.zervladpy.Utils.Interfaces;

import java.util.List;

public interface IDAO <T extends IEntity, ID> {
    T getById(ID id);
    List<T> getAll();
    void save(T entity);
    void saveMany(List<T> entities);
    void update(T entity);
    void delete(T entity);
}
