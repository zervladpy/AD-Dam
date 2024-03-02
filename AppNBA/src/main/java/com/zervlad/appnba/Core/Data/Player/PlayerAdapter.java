package com.zervlad.appnba.Core.Data.Player;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.zervlad.appnba.Core.Data.Team.TeamAdapter;

import java.io.IOException;

public class PlayerAdapter extends TypeAdapter<PlayerEntity> {
    @Override
    public void write(JsonWriter jsonWriter, PlayerEntity playerEntity) throws IOException {

    }

    @Override
    public PlayerEntity read(JsonReader jsonReader) throws IOException {

        PlayerEntity playerEntity = new PlayerEntity();

        TeamAdapter teamAdapter = new TeamAdapter();

        jsonReader.beginObject();

        while (jsonReader.hasNext()) {
            String name = jsonReader.nextName();
            switch (name) {
                case "id":
                    playerEntity.setId(jsonReader.nextInt());
                    break;
                case "first_name":
                    playerEntity.setFirstName(jsonReader.nextString());
                    break;
                case "last_name":
                    playerEntity.setLastName(jsonReader.nextString());
                    break;
                case "position":
                    playerEntity.setPosition(jsonReader.nextString());
                    break;
                case "team":
                    playerEntity.setTeamEntity(teamAdapter.read(jsonReader));
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }

        jsonReader.endObject();

        return playerEntity;
    }
}
