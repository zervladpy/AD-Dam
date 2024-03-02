package com.zervlad.appnba.Core.Data.Game;

import com.zervlad.appnba.Core.Data.Team.TeamEntity;
import com.zervlad.appnba.Utils.Enums.GameStatus;
import jakarta.persistence.*;

import java.util.Date;

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
    @JoinColumn(name = "home_team")
    @ManyToOne
    private TeamEntity homeTeamEntity;
    @JoinColumn(name = "visitor_team")
    @ManyToOne
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }

    public GameStatus getStatus() {
        return status;
    }

    public void setStatus(GameStatus status) {
        this.status = status;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public boolean isPostseason() {
        return postseason;
    }

    public void setPostseason(boolean postseason) {
        this.postseason = postseason;
    }

    public int getHomeTeamScore() {
        return homeTeamScore;
    }

    public void setHomeTeamScore(int homeTeamScore) {
        this.homeTeamScore = homeTeamScore;
    }

    public int getVisitorTeamScore() {
        return visitorTeamScore;
    }

    public void setVisitorTeamScore(int visitorTeamScore) {
        this.visitorTeamScore = visitorTeamScore;
    }

    public TeamEntity getHomeTeam() {
        return homeTeamEntity;
    }

    public void setHomeTeam(TeamEntity homeTeamEntity) {
        this.homeTeamEntity = homeTeamEntity;
    }

    public TeamEntity getVisitorTeam() {
        return visitorTeamEntity;
    }

    public void setVisitorTeam(TeamEntity visitorTeamEntity) {
        this.visitorTeamEntity = visitorTeamEntity;
    }
}
