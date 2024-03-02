package com.zervlad.appnba.Core.Data.Team;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.zervlad.appnba.Utils.Enums.Conference;

import java.io.IOException;

public class TeamAdapter extends TypeAdapter<TeamEntity> {


    @Override
    public void write(JsonWriter jsonWriter, TeamEntity teamEntity) throws IOException {
    }

    @Override
    public TeamEntity read(JsonReader in) throws IOException {

        TeamEntity teamEntity = new TeamEntity();

        in.beginObject();
        while (in.hasNext()) {
            String name = in.nextName();
            switch (name) {
                case "id":
                    teamEntity.setId(in.nextInt());
                    break;
                case "abbreviation":
                    teamEntity.setAbbreviation(in.nextString());
                    break;
                case "city":
                    teamEntity.setCity(in.nextString());
                    break;
                case "conference":
                    teamEntity.setConference(Conference.fromString(in.nextString()));
                    break;
                case "division":
                    teamEntity.setDivision(in.nextString());
                    break;
                case "full_name":
                    teamEntity.setFullName(in.nextString());
                    break;
                case "name":
                    teamEntity.setName(in.nextString());
                    break;
                default:
                    in.skipValue();
                    break;
            }
        }
        in.endObject();

        return teamEntity;
    }
}
