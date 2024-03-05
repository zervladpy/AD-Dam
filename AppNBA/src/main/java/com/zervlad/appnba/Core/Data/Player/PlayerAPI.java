package com.zervlad.appnba.Core.Data.Player;

import com.google.gson.Gson;
import com.zervlad.appnba.Core.Api.API;

public class PlayerAPI extends API<PlayerEntity> {

    public PlayerAPI(Gson gson, String apiKey, String url) {
        super(gson, apiKey, url, PlayerEntity[].class);
    }

    public PlayerAPI(String apiKey, String url) {
        super(apiKey, url, PlayerEntity[].class);
    }
}