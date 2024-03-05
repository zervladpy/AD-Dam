package com.zervlad.appnba.Core.Interfaces;

import java.util.List;

/**
 * Interface for repositories
 */
public interface IRepository<T> {

    List<T> getAll();

}
