package com.zervlad.appnba.Core.Data.Player;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.zervlad.appnba.Core.Data.Team.TeamAdapter;
import com.zervlad.appnba.Utils.Helpers.AppNBAHelper;

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
                case "height":
                    playerEntity.setHeight(AppNBAHelper.parseHeight(jsonReader.nextString()));
                    break;
                case "weight":
                    playerEntity.setWeight(AppNBAHelper.parseWeight(jsonReader.nextString()));
                    break;
                case "jersey_number":
                    playerEntity.setJersey(jsonReader.nextString());
                    break;
                case "college":
                    playerEntity.setCollege(jsonReader.nextString());
                    break;
                case "country":
                    playerEntity.setCountry(jsonReader.nextString());
                    break;
                case "draft_year":
                    if (jsonReader.peek() == JsonToken.NULL) {
                        jsonReader.nextNull();
                    } else {
                        playerEntity.setDraftYear(jsonReader.nextInt());
                    }
                    break;
                case "draft_round":
                    playerEntity.setDraftRound(jsonReader.nextInt());
                    break;
                case "draft_number":
                    playerEntity.setDraftNumber(jsonReader.nextInt());
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
