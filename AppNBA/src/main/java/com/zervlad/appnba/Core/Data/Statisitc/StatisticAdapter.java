package com.zervlad.appnba.Core.Data.Statisitc;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.zervlad.appnba.Core.Data.Game.GameAdapter;
import com.zervlad.appnba.Core.Data.Player.PlayerAdapter;
import com.zervlad.appnba.Core.Data.Team.TeamAdapter;

import java.io.IOException;

public class StatisticAdapter extends TypeAdapter<Statistic> {


    @Override
    public void write(JsonWriter jsonWriter, Statistic statistic) throws IOException {

    }

    @Override
    public Statistic read(JsonReader jsonReader) throws IOException {

        Statistic statistic = new Statistic();

        TeamAdapter teamAdapter = new TeamAdapter();
        GameAdapter gameAdapter = new GameAdapter();
        PlayerAdapter playerAdapter = new PlayerAdapter();

        jsonReader.beginObject();

        while (jsonReader.hasNext()) {
            String name = jsonReader.nextName();
            switch (name) {
                case "id" -> statistic.setId(jsonReader.nextInt());
                case "game" -> statistic.setGame(gameAdapter.read(jsonReader));
                case "team" -> statistic.setTeam(teamAdapter.read(jsonReader));
                case "player" -> statistic.setPlayer(playerAdapter.read(jsonReader));
                case "min" -> statistic.setMin(jsonReader.nextInt());
                case "fgm" -> statistic.setFgm(jsonReader.nextInt());
                case "fga" -> statistic.setFga(jsonReader.nextInt());
                case "fg3m" -> statistic.setFg3m(jsonReader.nextInt());
                case "fg3a" -> statistic.setFg3a(jsonReader.nextInt());
                case "ftm" -> statistic.setFtm(jsonReader.nextInt());
                case "fta" -> statistic.setFta(jsonReader.nextInt());
                case "oreb" -> statistic.setOreb(jsonReader.nextInt());
                case "dreb" -> statistic.setDreb(jsonReader.nextInt());
                case "reb" -> statistic.setReb(jsonReader.nextInt());
                case "ast" -> statistic.setAst(jsonReader.nextInt());
                case "stl" -> statistic.setStl(jsonReader.nextInt());
                case "blk" -> statistic.setBlk(jsonReader.nextInt());
                case "turnover" -> statistic.setTurnover(jsonReader.nextInt());
                case "pf" -> statistic.setPf(jsonReader.nextInt());
                case "pts" -> statistic.setPts(jsonReader.nextInt());
                default -> jsonReader.skipValue();
            }
        }

        jsonReader.endObject();
        return statistic;
    }
}
