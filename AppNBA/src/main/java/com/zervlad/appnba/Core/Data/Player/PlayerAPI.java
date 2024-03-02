package com.zervlad.appnba.Core.Data.Player;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.zervlad.appnba.Core.Interfaces.API;
import com.zervlad.appnba.Core.Requets.ApiRequest;
import com.zervlad.appnba.Utils.Constraints.Urls;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

public class PlayerAPI implements API<PlayerEntity> {

    private Gson gson;
    private ApiRequest apiRequest;

    public PlayerAPI(ApiRequest apiRequest, Gson gson) {
        this.apiRequest = apiRequest;
        this.gson = gson;
    }

    @Override
    public PlayerEntity[] getAll() throws URISyntaxException, IOException {

        URI uri = new URI(Urls.PLAYERS);

        JsonElement response = apiRequest.get(uri);

        return gson.fromJson(response, PlayerEntity[].class);

    }

    @Override
    public List<PlayerEntity> getWithParameters(String params) throws URISyntaxException, IOException {
        URI uri = new URI(Urls.PLAYERS + "/" + params);

        JsonElement response = apiRequest.get(uri);

        return List.of(gson.fromJson(response, PlayerEntity[].class));
    }
}
