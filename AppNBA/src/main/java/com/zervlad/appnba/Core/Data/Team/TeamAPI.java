package com.zervlad.appnba.Core.Data.Team;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.zervlad.appnba.Core.Interfaces.API;
import com.zervlad.appnba.Core.Requets.ApiRequest;
import com.zervlad.appnba.Utils.Constraints.Urls;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

public class TeamAPI implements API<TeamEntity> {

    private final ApiRequest apiRequest;
    private final Gson gson;

    public TeamAPI(Gson gson) {
        apiRequest = new ApiRequest();
        this.gson = gson;
    }

    public TeamAPI(ApiRequest apiRequest, Gson gson) {
        this.apiRequest = apiRequest;
        this.gson = gson;
    }

    @Override
    public TeamEntity[] getAll() throws URISyntaxException, IOException {

        URI uri = new URI(Urls.TEAMS);
        JsonElement response = apiRequest.get(uri);

        return gson.fromJson(response, TeamEntity[].class);
    }

    @Override
    public List<TeamEntity> getWithParameters(String params) throws URISyntaxException, IOException {
        // TODO: Create URI Builder
        URI uri = new URI(Urls.TEAMS + "/" + params);
        JsonElement response = apiRequest.get(uri);

        return List.of(gson.fromJson(response, TeamEntity[].class));
    }
}
