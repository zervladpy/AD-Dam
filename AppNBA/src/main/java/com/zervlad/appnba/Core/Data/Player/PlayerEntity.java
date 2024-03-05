package com.zervlad.appnba.Core.Data.Player;

import com.zervlad.appnba.Core.Data.Team.TeamEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "players")
public class PlayerEntity {

    @Id
    @Column(name = "player_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "position")
    private String position;
    @Column(name = "height")
    private double height;
    @Column(name = "weight")
    private double weight;
    @Column(name = "jersey")
    private String jersey;
    @Column(name = "country")
    private String country;
    @Column(name = "draft_year")
    private int draftYear;
    @Column(name = "draft_round")
    private int draftRound;
    @Column(name = "draft_number")
    private int draftNumber;
    @Column(name = "college")
    private String college;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "team_id")
    private TeamEntity teamEntity;

    public PlayerEntity() {
    }

    public PlayerEntity(int id, String firstName, String lastName, String position, double height, double weight, String jersey, String country, int draftYear, int draftRound, int draftNumber, String college, TeamEntity teamEntity) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.height = height;
        this.weight = weight;
        this.jersey = jersey;
        this.country = country;
        this.draftYear = draftYear;
        this.draftRound = draftRound;
        this.draftNumber = draftNumber;
        this.college = college;
        this.teamEntity = teamEntity;
    }

}
