package com.zervlad.appnba.Core.Services;

import com.google.gson.Gson;
import com.zervlad.appnba.Core.Data.Game.GameAdapter;
import com.zervlad.appnba.Core.Data.Game.GameEntity;
import com.zervlad.appnba.Core.Data.Player.PlayerAdapter;
import com.zervlad.appnba.Core.Data.Player.PlayerEntity;
import com.zervlad.appnba.Core.Data.Statisitc.Statistic;
import com.zervlad.appnba.Core.Data.Statisitc.StatisticAdapter;
import com.zervlad.appnba.Core.Data.Team.TeamAdapter;
import com.zervlad.appnba.Core.Data.Team.TeamEntity;

public class GsonManagerNBA {

    private static Gson gson;

    public static Gson getInstance() {
        if (gson == null) {
            synchronized (Gson.class) {
                if (gson == null) {
                    gson = new Gson().newBuilder()
                            .registerTypeAdapter(TeamEntity.class, new TeamAdapter())
                            .registerTypeAdapter(PlayerEntity.class, new PlayerAdapter())
                            .registerTypeAdapter(GameEntity.class, new GameAdapter())
                            .registerTypeAdapter(Statistic.class, new StatisticAdapter())
                            .create();
                }
            }
        }
        return gson;
    }

}
