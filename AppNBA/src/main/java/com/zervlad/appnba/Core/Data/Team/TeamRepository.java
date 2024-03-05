package com.zervlad.appnba.Core.Data.Team;

import com.zervlad.appnba.Core.Api.IAPI;
import com.zervlad.appnba.Core.Data.Interfaces.IDAO;
import com.zervlad.appnba.Core.Repositories.Repository;

public class TeamRepository extends Repository<TeamEntity> {
    public TeamRepository(IDAO<TeamEntity> local, IAPI<TeamEntity> remote) {
        super(local, remote);
    }
}
