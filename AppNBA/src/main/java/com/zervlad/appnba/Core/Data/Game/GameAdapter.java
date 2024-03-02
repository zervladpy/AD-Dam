package com.zervlad.appnba.Core.Data.Game;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.zervlad.appnba.Core.Data.Team.TeamAdapter;

import java.io.IOException;
import java.sql.Date;

public class GameAdapter extends TypeAdapter<GameEntity> {
    @Override
    public void write(JsonWriter jsonWriter, GameEntity gameEntity) throws IOException {

    }

    @Override
    public GameEntity read(JsonReader jsonReader) throws IOException {

        GameEntity gameEntity = new GameEntity();

        TeamAdapter teamAdapter = new TeamAdapter();

        jsonReader.beginObject();

        while (jsonReader.hasNext()) {
            String name = jsonReader.nextName();
            switch (name) {
                case "id" -> gameEntity.setId(jsonReader.nextInt());
                case "date" -> {
                    String date = jsonReader.nextString();
                    int year = Integer.parseInt(date.substring(0, 4));
                    int month = Integer.parseInt(date.substring(5, 7));
                    int day = Integer.parseInt(date.substring(8, 10));

                    gameEntity.setDate(new Date(year, month, day));
                }
                case "homeTeam" -> gameEntity.setHomeTeam(teamAdapter.read(jsonReader));
                case "visitorTeam" -> gameEntity.setVisitorTeam(teamAdapter.read(jsonReader));
                case "homeTeamScore" -> gameEntity.setHomeTeamScore(jsonReader.nextInt());
                case "visitorTeamScore" -> gameEntity.setVisitorTeamScore(jsonReader.nextInt());
                default -> jsonReader.skipValue();
            }
        }

        jsonReader.endObject();

        return gameEntity;

    }
}
