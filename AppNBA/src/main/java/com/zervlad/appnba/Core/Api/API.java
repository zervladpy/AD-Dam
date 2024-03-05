package com.zervlad.appnba.Core.Api;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import com.zervlad.appnba.Core.Services.DependenciesManagerNBA;
import com.zervlad.appnba.Utils.Builder.UrlBuilder;
import com.zervlad.appnba.Utils.Constraints.ApiConstraints;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class API<T> implements IAPI<T> {

    private final Gson gson;
    private final int cursorLen = 100;
    private final TContainer typeContainer;
    private String url;
    private String apiKey;

    public API(Gson gson, String apiKey, String url, Class<T[]> cls) {
        this.gson = gson;
        this.apiKey = apiKey;
        this.url = url;
        typeContainer = new TContainer<>(cls);
    }

    public API(String apiKey, String url, Class<T[]> cls) {
        this.gson = DependenciesManagerNBA.getInstance().getDependency(Gson.class);
        this.apiKey = apiKey;
        this.url = url;
        typeContainer = new TContainer<>(cls);
    }

    @Override
    public List<T> getAll() throws URISyntaxException, IOException {
        List<T> objects = new ArrayList<>();

        boolean reachEnd = false;
        String currentCursor = "0";

        while (!reachEnd) {
            String currentUrl = UrlBuilder.builder().setUrl(this.url)
                    .setParameter("cursor", currentCursor)
                    .setParameter("per_page", String.valueOf(cursorLen))
                    .getUrl();

            JsonObject response = request(new URI(currentUrl));

            var data = response.get("data");

            List<T> cursorObjects = List.of(gson.fromJson(data, (Type) typeContainer.getC()));

            var meta = response.get("meta").getAsJsonObject();

            String nextCursor = meta.get("meta").getAsString();

            currentCursor = String.valueOf(nextCursor);

            if (cursorObjects.size() < cursorLen) {
                reachEnd = true;
            }

            objects.addAll(cursorObjects);

        }


        return objects;
    }

    @Override
    public List<T> getAll(String parameters) {
        return null;
    }

    private JsonObject request(URI uri) throws IOException {
        URLConnection request = uri.toURL().openConnection();
        request.setRequestProperty(ApiConstraints.API_KEY_NAME, apiKey);
        request.setRequestProperty("Content-Type", "application/json");
        request.connect();

        JsonReader jsonReader = new JsonReader(new InputStreamReader((InputStream) request.getContent()));
        jsonReader.setLenient(true);

        return JsonParser.parseReader(jsonReader).getAsJsonObject();
    }

    private class TContainer<T> {
        private T type;

        public TContainer(T t) {
            type = t;
        }

        public Class<?> getC() {
            return type.getClass();
        }


    }
}
