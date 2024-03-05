package com.zervlad.appnba.Core.Data.Player;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.zervlad.appnba.Core.Interfaces.IAPI;
import com.zervlad.appnba.Core.Requets.ApiRequest;
import com.zervlad.appnba.Utils.Constraints.Urls;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class PlayerIAPI implements IAPI<PlayerEntity> {

    private Gson gson;
    private ApiRequest apiRequest;

    public PlayerIAPI(ApiRequest apiRequest, Gson gson) {
        this.apiRequest = apiRequest;
        this.gson = gson;
    }

    @Override
    public List<PlayerEntity> getAll() throws URISyntaxException, IOException {
        var cursor_len = 100;
        boolean isEnd = false;

        List<PlayerEntity> players = new ArrayList<>();

        while (!isEnd) {
            URI uri = new URI(Urls.PLAYERS + "?per_page=" + cursor_len);

            JsonElement response = apiRequest.get(uri);

            players.addAll(List.of(gson.fromJson(response.getAsJsonObject().get("data"), PlayerEntity[].class)));

            var meta = response.getAsJsonObject().get("meta").getAsJsonObject();
            var next_cursor = meta.get("next_cursor").getAsInt();

            if (next_cursor < cursor_len) {
                isEnd = true;
            }

            cursor_len += 100;
        }

        return players;

    }

    @Override
    public List<PlayerEntity> getWithParameters(String params) throws URISyntaxException, IOException {
        URI uri = new URI(Urls.PLAYERS + "/" + params);

        JsonElement response = apiRequest.get(uri);

        return List.of(gson.fromJson(response, PlayerEntity[].class));
    }
}
