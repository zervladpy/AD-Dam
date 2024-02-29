package com.zervlad.appnba.Core.Local.Entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity(name = "match")
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    // @Column(name = "home_team")
    // private Team homeTeam;
    // @Column(name = "visitor_team")
    // private Team visitorTeam;
    @Column(name = "season")
    private int season;
    @Column(name = "period")
    private int period;
    @Column(name = "postseason")
    private boolean postseason;
    @Column(name = "home_team_score")
    private int homeTeamScore;
    @Column(name = "visitor_team_score")
    private int visitorTeamScore;

}
