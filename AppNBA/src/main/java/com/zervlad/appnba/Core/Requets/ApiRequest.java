package com.zervlad.appnba.Core.Requets;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import com.zervlad.appnba.Utils.Constraints.ApiConstraints;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URLConnection;

public class ApiRequest {

    private final String apiKey;

    /**
     * Default constructor with default API key
     */
    public ApiRequest() {
        this.apiKey = ApiConstraints.API_KEY_VALUE;
    }

    /**
     * Constructor with custom API key
     *
     * @param apiKey custom API key
     */
    public ApiRequest(String apiKey) {
        this.apiKey = apiKey;
    }

    public JsonElement get(URI uri) throws IOException {
        URLConnection request = uri.toURL().openConnection();
        request.setRequestProperty(ApiConstraints.API_KEY_NAME, apiKey);
        request.setRequestProperty("Content-Type", "application/json");
        request.connect();

        JsonReader jsonReader = new JsonReader(new InputStreamReader((InputStream) request.getContent()));
        jsonReader.setLenient(true);

        return JsonParser.parseReader(jsonReader).getAsJsonObject().get("data");

    }

}
