package com.zervlad.appnba.Core.Data.Game;

import com.google.gson.Gson;
import com.zervlad.appnba.Core.Api.API;

public class GameAPI extends API<GameEntity> {


    public GameAPI(Gson gson, String apiKey, String url) {
        super(gson, apiKey, url, GameEntity[].class);
    }

    public GameAPI(String apiKey, String url) {
        super(apiKey, url, GameEntity[].class);
    }
}
