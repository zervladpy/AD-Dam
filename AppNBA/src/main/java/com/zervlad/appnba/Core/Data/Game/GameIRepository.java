package com.zervlad.appnba.Core.Data.Game;

import com.zervlad.appnba.Core.Interfaces.IAPI;
import com.zervlad.appnba.Core.Interfaces.IDAO;
import com.zervlad.appnba.Core.Interfaces.IRepository;

import java.util.List;

public class GameIRepository implements IRepository<GameEntity> {

    private final IAPI<GameEntity> remote;
    private final IDAO<GameEntity> local;

    public GameIRepository(IAPI<GameEntity> remote, IDAO<GameEntity> local) {
        this.remote = remote;
        this.local = local;
    }

    @Override
    public List<GameEntity> getAll() {

        List<GameEntity> games;

        try {
            games = remote.getAll();
            System.out.println("Game remote incoming: " + games.size());
            // Replacing local data with remote data
            local.drop();
            local.insertAll(games);

        } catch (Exception e) {
            // When no internet connection, get data from local
            games = local.getAll();
        }

        return games;

    }
}
