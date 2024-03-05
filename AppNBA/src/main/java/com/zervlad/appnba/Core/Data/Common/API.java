package com.zervlad.appnba.Core.Data.Common;

import com.google.gson.JsonObject;
import com.zervlad.appnba.Core.Interfaces.IAPI;
import com.zervlad.appnba.Core.Requets.ApiRequest;
import com.zervlad.appnba.Core.Services.DependenciesManagerNBA;
import com.zervlad.appnba.Utils.Helpers.AUrlBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class API<T> implements IAPI<T> {

    /**
     * Starting point for API requests
     * Commonly a URL
     */
    private final String baseUrl;
    private final int cursorLength;
    private final ApiRequest apiRequest;
    private int currentCursor;

    public API(String baseUrl, ApiRequest apiRequest, int cursorLength) {
        this.baseUrl = baseUrl;
        this.cursorLength = cursorLength;
        this.apiRequest = apiRequest;
        this.currentCursor = 0;
    }

    public API(String baseUrl) {
        this.apiRequest = DependenciesManagerNBA.getInstance().getDependency(ApiRequest.class);
        this.baseUrl = baseUrl;
        this.cursorLength = 25;
        this.currentCursor = 0;
    }

    @Override
    public List<T> getAll() throws URISyntaxException, IOException {
        List<T> result = new ArrayList<>();
        boolean isEnd = false;

        while (!isEnd) {
            String url = new AUrlBuilder(baseUrl)
                    .addParameter("cursor", String.valueOf(currentCursor))
                    .addParameter("per_page", String.valueOf(cursorLength))
                    .getUrl();

            JsonObject response = apiRequest.get(new URI(url));

            List<T> cursorItems = gson.fromJson(); // TODO
        }

        return result;
    }

    @Override
    public List<T> getWithParameters(String params) throws URISyntaxException, IOException {
        return null;
    }
}
