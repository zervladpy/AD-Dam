package com.zervlad.appnba.Core.Data.Game;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.zervlad.appnba.Core.Interfaces.IAPI;
import com.zervlad.appnba.Core.Requets.ApiRequest;
import com.zervlad.appnba.Utils.Constraints.Urls;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

public class GameIAPI implements IAPI<GameEntity> {

    private final Gson gson;
    private final ApiRequest apiRequest;

    public GameIAPI(Gson gson, ApiRequest apiRequest) {
        this.gson = gson;
        this.apiRequest = apiRequest;
    }

    @Override
    public List<GameEntity> getAll() throws URISyntaxException, IOException {
        URI uri = new URI(Urls.GAMES);

        JsonElement response = apiRequest.get(uri);

        return List.of(gson.fromJson(response.getAsJsonObject().get("data"), GameEntity[].class));
    }

    @Override
    public List<GameEntity> getWithParameters(String params) throws URISyntaxException, IOException {
        URI uri = new URI(Urls.GAMES + "/" + params);

        JsonElement response = apiRequest.get(uri);

        return List.of(gson.fromJson(response, GameEntity[].class));
    }
}
