package com.zervlad.appnba.Core.Data.Player;

import com.zervlad.appnba.Core.Interfaces.API;
import com.zervlad.appnba.Core.Interfaces.DAO;
import com.zervlad.appnba.Core.Repositories.Repository;

import java.util.List;

public class PlayerRepository implements Repository<PlayerEntity> {

    private final API<PlayerEntity> remote;
    private final DAO<PlayerEntity> local;

    public PlayerRepository(API<PlayerEntity> remote, DAO<PlayerEntity> local) {
        this.remote = remote;
        this.local = local;
    }

    @Override
    public List<PlayerEntity> getAll() {

        PlayerEntity[] players;

        try {
            players = remote.getAll();
            System.out.println("Player remote incoming: " + players.length);
            // Replacing local data with remote data
            local.drop();
            local.insertAll(players);

        } catch (Exception e) {
            // When no internet connection, get data from local
            players = local.getAll();
        }

        return List.of(players);

    }
}
