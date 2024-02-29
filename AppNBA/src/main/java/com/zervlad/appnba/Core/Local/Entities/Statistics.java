package com.zervlad.appnba.Core.Local.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Create a entity class (only attributes) for the statistics of the players.
 * {
 * "data": [
 * {
 * "id": 14325883,
 * "min": "38",
 * "fgm": 10,
 * "fga": 16,
 * "fg_pct": 0.625,
 * "fg3m": 0,
 * "fg3a": 1,
 * "fg3_pct": 0,
 * "ftm": 11,
 * "fta": 22,
 * "ft_pct": 0.5,
 * "oreb": 3,
 * "dreb": 7,
 * "reb": 10,
 * "ast": 9,
 * "stl": 2,
 * "blk": 1,
 * "turnover": 5,
 * "pf": 1,
 * "pts": 31,
 * "player": {
 * "id": 15,
 * "first_name": "Giannis",
 * "last_name": "Antetokounmpo",
 * "position": "F",
 * "height": "6-11",
 * "weight": "243",
 * "jersey_number": "34",
 * "college": "Filathlitikos",
 * "country": "Greece",
 * "draft_year": 2013,
 * "draft_round": 1,
 * "draft_number": 15,
 * "team_id": 17
 * },
 * "team": {
 * "id": 17,
 * "conference": "East",
 * "division": "Central",
 * "city": "Milwaukee",
 * "name": "Bucks",
 * "full_name": "Milwaukee Bucks",
 * "abbreviation": "MIL"
 * },
 * "game": {
 * "id": 1038184,
 * "date": "2024-01-20",
 * "season": 2023,
 * "status": "Final",
 * "period": 4,
 * "time": "Final",
 * "postseason": false,
 * "home_team_score": 135,
 * "visitor_team_score": 141,
 * "home_team_id": 9,
 * "visitor_team_id": 17
 * }
 * },
 * ...
 * ],
 * "meta": {
 * "next_cursor": 14325888,
 * "per_page": 25
 * }
 * }
 */
@Entity
public class Statistics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String min;
    private int fgm;
    private int fga;
    private double fgPct;
    private int fg3m;
    private int fg3a;
    private double fg3Pct;
    private int ftm;
    private int fta;
    private double ftPct;
    private int oreb;
    private int dreb;
    private int reb;
    private int ast;
    private int stl;
    private int blk;
    private int turnover;
    private int pf;
    private int pts;
    // private Player player;
    // private Team team;
    // private Match game;

}
