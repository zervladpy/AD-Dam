package com.zervlad.appnba.Core.Data.Statisitc;

import com.zervlad.appnba.Core.Data.Game.GameEntity;
import com.zervlad.appnba.Core.Data.Player.PlayerEntity;
import com.zervlad.appnba.Core.Data.Team.TeamEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "stats")
public class Statistic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "min")
    private int min;
    @Column(name = "fgm")
    private int fgm;
    @Column(name = "fga")
    private int fga;
    @Column(name = "fg_pct")
    private double fgPct;
    @Column(name = "fg3m")
    private int fg3m;
    @Column(name = "fg3a")
    private int fg3a;
    @Column(name = "fg3_pct")
    private double fg3Pct;
    @Column(name = "ftm")
    private int ftm;
    @Column(name = "fta")
    private int fta;
    @Column(name = "ft_pct")
    private double ftPct;
    @Column(name = "oreb")
    private int oreb;
    @Column(name = "dreb")
    private int dreb;
    @Column(name = "reb")
    private int reb;
    @Column(name = "ast")
    private int ast;
    @Column(name = "stl")
    private int stl;
    @Column(name = "blk")
    private int blk;
    @Column(name = "turnover")
    private int turnover;
    @Column(name = "pf")
    private int pf;
    @Column(name = "pts")
    private int pts;
    @JoinColumn(name = "player")
    @ManyToOne
    private PlayerEntity playerEntity;
    @JoinColumn(name = "team")
    @ManyToOne
    private TeamEntity teamEntity;
    @JoinColumn(name = "game")
    @ManyToOne
    private GameEntity gameEntity;

    public Statistic() {
    }

    public Statistic(int id, int min, int fgm, int fga, double fgPct, int fg3m, int fg3a, double fg3Pct, int ftm, int fta, double ftPct, int oreb, int dreb, int reb, int ast, int stl, int blk, int turnover, int pf, int pts, PlayerEntity playerEntity, TeamEntity teamEntity, GameEntity gameEntity) {
        this.id = id;
        this.min = min;
        this.fgm = fgm;
        this.fga = fga;
        this.fgPct = fgPct;
        this.fg3m = fg3m;
        this.fg3a = fg3a;
        this.fg3Pct = fg3Pct;
        this.ftm = ftm;
        this.fta = fta;
        this.ftPct = ftPct;
        this.oreb = oreb;
        this.dreb = dreb;
        this.reb = reb;
        this.ast = ast;
        this.stl = stl;
        this.blk = blk;
        this.turnover = turnover;
        this.pf = pf;
        this.pts = pts;
        this.playerEntity = playerEntity;
        this.teamEntity = teamEntity;
        this.gameEntity = gameEntity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getFgm() {
        return fgm;
    }

    public void setFgm(int fgm) {
        this.fgm = fgm;
    }

    public int getFga() {
        return fga;
    }

    public void setFga(int fga) {
        this.fga = fga;
    }

    public double getFgPct() {
        return fgPct;
    }

    public void setFgPct(double fgPct) {
        this.fgPct = fgPct;
    }

    public int getFg3m() {
        return fg3m;
    }

    public void setFg3m(int fg3m) {
        this.fg3m = fg3m;
    }

    public int getFg3a() {
        return fg3a;
    }

    public void setFg3a(int fg3a) {
        this.fg3a = fg3a;
    }

    public double getFg3Pct() {
        return fg3Pct;
    }

    public void setFg3Pct(double fg3Pct) {
        this.fg3Pct = fg3Pct;
    }

    public int getFtm() {
        return ftm;
    }

    public void setFtm(int ftm) {
        this.ftm = ftm;
    }

    public int getFta() {
        return fta;
    }

    public void setFta(int fta) {
        this.fta = fta;
    }

    public double getFtPct() {
        return ftPct;
    }

    public void setFtPct(double ftPct) {
        this.ftPct = ftPct;
    }

    public int getOreb() {
        return oreb;
    }

    public void setOreb(int oreb) {
        this.oreb = oreb;
    }

    public int getDreb() {
        return dreb;
    }

    public void setDreb(int dreb) {
        this.dreb = dreb;
    }

    public int getReb() {
        return reb;
    }

    public void setReb(int reb) {
        this.reb = reb;
    }

    public int getAst() {
        return ast;
    }

    public void setAst(int ast) {
        this.ast = ast;
    }

    public int getStl() {
        return stl;
    }

    public void setStl(int stl) {
        this.stl = stl;
    }

    public int getBlk() {
        return blk;
    }

    public void setBlk(int blk) {
        this.blk = blk;
    }

    public int getTurnover() {
        return turnover;
    }

    public void setTurnover(int turnover) {
        this.turnover = turnover;
    }

    public int getPf() {
        return pf;
    }

    public void setPf(int pf) {
        this.pf = pf;
    }

    public int getPts() {
        return pts;
    }

    public void setPts(int pts) {
        this.pts = pts;
    }

    public PlayerEntity getPlayer() {
        return playerEntity;
    }

    public void setPlayer(PlayerEntity playerEntity) {
        this.playerEntity = playerEntity;
    }

    public TeamEntity getTeam() {
        return teamEntity;
    }

    public void setTeam(TeamEntity teamEntity) {
        this.teamEntity = teamEntity;
    }

    public GameEntity getGame() {
        return gameEntity;
    }

    public void setGame(GameEntity gameEntity) {
        this.gameEntity = gameEntity;
    }
}
