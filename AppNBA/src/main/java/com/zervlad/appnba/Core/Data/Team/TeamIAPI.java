package com.zervlad.appnba.Core.Data.Team;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.zervlad.appnba.Core.Interfaces.IAPI;
import com.zervlad.appnba.Core.Requets.ApiRequest;
import com.zervlad.appnba.Utils.Constraints.Urls;
import com.zervlad.appnba.Utils.Helpers.AUrlBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class TeamIAPI implements IAPI<TeamEntity> {

    private final ApiRequest apiRequest;
    private final Gson gson;

    public TeamIAPI(Gson gson) {
        apiRequest = new ApiRequest();
        this.gson = gson;
    }

    public TeamIAPI(ApiRequest apiRequest, Gson gson) {
        this.apiRequest = apiRequest;
        this.gson = gson;
    }

    @Override
    public List<TeamEntity> getAll() throws URISyntaxException, IOException {
        var cursor_len = 100;
        boolean isEnd = false;
        String nextCursor = "0";

        List<TeamEntity> teams = new ArrayList<>();
        while (!isEnd) {

            String url = new AUrlBuilder(Urls.TEAMS)
                    .addParameter("cursor", nextCursor)
                    .addParameter("per_page", String.valueOf(cursor_len))
                    .getUrl();


            JsonElement response = apiRequest.get(new URI(url));

            nextCursor = response.getAsJsonObject().get("meta").getAsJsonObject().get("next_cursor").getAsString();

            List<TeamEntity> cursor_teams = List.of(gson.fromJson(response.getAsJsonObject().get("data"), TeamEntity[].class));

            teams.addAll(cursor_teams);

            if (cursor_teams.size() < cursor_len) {
                isEnd = true;
            }

            cursor_len += 100;
        }

        return teams;
    }

    @Override
    public List<TeamEntity> getWithParameters(String params) throws URISyntaxException, IOException {
        // TODO: Create URI Builder
        URI uri = new URI(Urls.TEAMS + "/" + params);
        JsonElement response = apiRequest.get(uri);

        return List.of(gson.fromJson(response, TeamEntity[].class));
    }
}
