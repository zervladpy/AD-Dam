package com.zervlad.appnba.Core.Data.Team;

import com.zervlad.appnba.Core.Interfaces.API;
import com.zervlad.appnba.Core.Interfaces.DAO;
import com.zervlad.appnba.Core.Repositories.Repository;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

/**
 * Repository implementation for Team entity
 */
public class TeamRepository implements Repository<TeamEntity> {

    private final API<TeamEntity> remote;
    private final DAO<TeamEntity> local;

    public TeamRepository(API<TeamEntity> remote, DAO<TeamEntity> local) {
        this.remote = remote;
        this.local = local;
    }

    @Override
    public List<TeamEntity> getAll() {

        TeamEntity[] teams;

        try {
            teams = remote.getAll();
            System.out.println("Remote data: " + teams.length);
            // Replacing local data with remote data
            local.drop();
            local.insertAll(teams);

        } catch (IOException e) {
            // When no internet connection, get data from local
            teams = local.getAll();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        return List.of(teams);
    }
}
