package com.zervlad.appnba.Core.Data.Team;

import com.google.gson.Gson;
import com.zervlad.appnba.Core.Api.API;

public class TeamAPI extends API<TeamEntity> {

    public TeamAPI(Gson gson, String apiKey, String url) {
        super(gson, apiKey, url, TeamEntity[].class);
    }

    public TeamAPI(String apiKey, String url) {
        super(apiKey, url, TeamEntity[].class);
    }
}