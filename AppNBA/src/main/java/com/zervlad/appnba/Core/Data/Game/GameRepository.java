package com.zervlad.appnba.Core.Data.Game;

import com.zervlad.appnba.Core.Api.IAPI;
import com.zervlad.appnba.Core.Data.Interfaces.IDAO;
import com.zervlad.appnba.Core.Repositories.Repository;

public class GameRepository extends Repository<GameEntity> {
    public GameRepository(IDAO<GameEntity> local, IAPI<GameEntity> remote) {
        super(local, remote);
    }
}
