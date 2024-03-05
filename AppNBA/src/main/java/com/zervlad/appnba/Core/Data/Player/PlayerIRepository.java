package com.zervlad.appnba.Core.Data.Player;

import com.zervlad.appnba.Core.Interfaces.IAPI;
import com.zervlad.appnba.Core.Interfaces.IDAO;
import com.zervlad.appnba.Core.Interfaces.IRepository;

import java.util.List;

public class PlayerIRepository implements IRepository<PlayerEntity> {

    private final IAPI<PlayerEntity> remote;
    private final IDAO<PlayerEntity> local;

    public PlayerIRepository(IAPI<PlayerEntity> remote, IDAO<PlayerEntity> local) {
        this.remote = remote;
        this.local = local;
    }

    @Override
    public List<PlayerEntity> getAll() {

        List<PlayerEntity> players;

        try {
            players = remote.getAll();
            System.out.println("Player remote incoming: " + players.size());
            // Replacing local data with remote data
            local.drop();
            local.insertAll(players);

        } catch (Exception e) {
            // When no internet connection, get data from local
            players = local.getAll();
        }

        return players;

    }
}
