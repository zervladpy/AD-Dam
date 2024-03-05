package com.zervlad.appnba.Core.Data.Team;

import com.zervlad.appnba.Core.Interfaces.IAPI;
import com.zervlad.appnba.Core.Interfaces.IDAO;
import com.zervlad.appnba.Core.Interfaces.IRepository;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

/**
 * Repository implementation for Team entity
 */
public class TeamIRepository implements IRepository<TeamEntity> {

    private final IAPI<TeamEntity> remote;
    private final IDAO<TeamEntity> local;

    public TeamIRepository(IAPI<TeamEntity> remote, IDAO<TeamEntity> local) {
        this.remote = remote;
        this.local = local;
    }

    @Override
    public List<TeamEntity> getAll() {

        List<TeamEntity> teams;

        try {
            teams = remote.getAll();
            System.out.println("Remote data: " + teams.size());
            // Replacing local data with remote data
            local.drop();
            local.insertAll(teams);

        } catch (IOException e) {
            // When no internet connection, get data from local
            teams = local.getAll();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        return teams;
    }
}
