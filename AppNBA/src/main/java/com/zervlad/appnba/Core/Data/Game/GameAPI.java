package com.zervlad.appnba.Core.Data.Game;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.zervlad.appnba.Core.Interfaces.API;
import com.zervlad.appnba.Core.Requets.ApiRequest;
import com.zervlad.appnba.Utils.Constraints.Urls;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

public class GameAPI implements API<GameEntity> {

    private Gson gson;
    private ApiRequest apiRequest;

    public GameAPI(Gson gson, ApiRequest apiRequest) {
        this.gson = gson;
        this.apiRequest = apiRequest;
    }

    @Override
    public GameEntity[] getAll() throws URISyntaxException, IOException {
        URI uri = new URI(Urls.GAMES);

        JsonElement response = apiRequest.get(uri);

        return gson.fromJson(response, GameEntity[].class);
    }

    @Override
    public List<GameEntity> getWithParameters(String params) throws URISyntaxException, IOException {
        URI uri = new URI(Urls.GAMES + "/" + params);

        JsonElement response = apiRequest.get(uri);

        return List.of(gson.fromJson(response, GameEntity[].class));
    }
}
