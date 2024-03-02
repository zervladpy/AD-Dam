package com.zervlad.appnba.Utils.Constraints;

public class Urls {

    public static final String BASE_URL = "https://api.balldontlie.io/v1/";
    public static final String TEAMS = BASE_URL + "teams";
    public static final String PLAYERS = BASE_URL + "players";
    public static final String GAMES = BASE_URL + "games?seasons[]=2023"; // TODO: change to dynamic season
    public static final String STATISTICS = BASE_URL + "stats?seasons[]=2023";
    ;
}
