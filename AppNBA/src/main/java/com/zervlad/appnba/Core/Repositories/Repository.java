package com.zervlad.appnba.Core.Repositories;

import com.zervlad.appnba.Core.Api.IAPI;
import com.zervlad.appnba.Core.Data.Interfaces.IDAO;

import java.util.List;

public class Repository<T> implements IRepository<T> {

    /**
     * Local storage
     */
    private final IDAO<T> local;
    /**
     * Remote storage
     */
    private final IAPI<T> remote;

    public Repository(IDAO<T> local, IAPI<T> remote) {
        this.local = local;
        this.remote = remote;
    }

    @Override
    public List<T> getAll() {
        return local.getAll();
    }
}
