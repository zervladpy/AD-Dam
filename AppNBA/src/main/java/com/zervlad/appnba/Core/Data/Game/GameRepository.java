package com.zervlad.appnba.Core.Data.Game;

import com.zervlad.appnba.Core.Interfaces.API;
import com.zervlad.appnba.Core.Interfaces.DAO;
import com.zervlad.appnba.Core.Repositories.Repository;

import java.util.List;

public class GameRepository implements Repository<GameEntity> {

    private final API<GameEntity> remote;
    private final DAO<GameEntity> local;

    public GameRepository(API<GameEntity> remote, DAO<GameEntity> local) {
        this.remote = remote;
        this.local = local;
    }

    @Override
    public List<GameEntity> getAll() {

        GameEntity[] games;

        try {
            games = remote.getAll();
            System.out.println("Game remote incoming: " + games.length);
            // Replacing local data with remote data
            local.drop();
            local.insertAll(games);

        } catch (Exception e) {
            // When no internet connection, get data from local
            games = local.getAll();
        }

        return List.of(games);

    }
}
