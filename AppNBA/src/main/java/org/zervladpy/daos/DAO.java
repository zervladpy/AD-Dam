package org.zervladpy.daos;

import org.zervladpy.models.Team;

import java.util.List;

public interface DAO<T> {
    
    T getById(int id);

    List<T> getAll();

    int insert(T model);

    int delete(T model);

    int update(T model);

    List<Integer> bunchInsert(List<T> models);
}
