package com.zervlad.appnba.Core.Data.Game;

import com.zervlad.appnba.Core.Data.Team.TeamEntity;
import com.zervlad.appnba.Utils.Enums.GameStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity(name = "games")
public class GameEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column(name = "season")
    private int season;
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private GameStatus status;

    @Column(name = "period")
    private int period;

    @Column(name = "time") // Review this column
    private String time;

    @Column(name = "postseason")
    private boolean postseason;

    @Column(name = "home_team_score")
    private int homeTeamScore;

    @Column(name = "visitor_team_score")
    private int visitorTeamScore;

    @ManyToOne
    @JoinColumn(name = "home_team_id", referencedColumnName = "team_id")
    private TeamEntity homeTeamEntity;

    @ManyToOne
    @JoinColumn(name = "visitor_team_id", referencedColumnName = "team_id")
    private TeamEntity visitorTeamEntity;

    public GameEntity() {
    }

    public GameEntity(int id, Date date, int season, GameStatus status, int period, String time, boolean postseason, int homeTeamScore, int visitorTeamScore, TeamEntity homeTeamEntity, TeamEntity visitorTeamEntity) {
        this.id = id;
        this.date = date;
        this.season = season;
        this.status = status;
        this.period = period;
        this.time = time;
        this.postseason = postseason;
        this.homeTeamScore = homeTeamScore;
        this.visitorTeamScore = visitorTeamScore;
        this.homeTeamEntity = homeTeamEntity;
        this.visitorTeamEntity = visitorTeamEntity;
    }
}
