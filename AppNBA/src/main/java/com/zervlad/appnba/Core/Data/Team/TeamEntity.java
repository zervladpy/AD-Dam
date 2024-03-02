package com.zervlad.appnba.Core.Data.Team;

import com.google.gson.annotations.JsonAdapter;
import com.zervlad.appnba.Core.Data.Player.PlayerEntity;
import com.zervlad.appnba.Utils.Enums.Conference;
import jakarta.persistence.*;

@Entity
@Table(name = "teams")
@JsonAdapter(TeamAdapter.class)
public class TeamEntity {

    @Id
    @Column(name = "team_id")
    private int id;
    @Column(name = "conference")
    @Enumerated(EnumType.STRING)
    private Conference conference;
    @Column(name = "division")
    private String division;
    @Column(name = "city")
    private String city;
    @Column(name = "name")
    private String name;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "abbreviation")
    private String abbreviation;

    @OneToMany(mappedBy = "teamEntity", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private PlayerEntity[] players;

    public TeamEntity() {
    }

    public TeamEntity(int id, Conference conference, String division, String city, String name, String fullName, String abbreviation, PlayerEntity[] players) {
        this.id = id;
        this.conference = conference;
        this.division = division;
        this.city = city;
        this.name = name;
        this.fullName = fullName;
        this.abbreviation = abbreviation;
        this.players = players;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Conference getConference() {
        return conference;
    }

    public void setConference(Conference conference) {
        this.conference = conference;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public PlayerEntity[] getPlayers() {
        return players;
    }

    public void setPlayers(PlayerEntity[] players) {
        this.players = players;
    }
}
