package org.zervladpy.models;

import jakarta.persistence.*;

@Table(name = "team")
@Entity(name = "Team")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teamId")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "city")
    private String city;

    @Column(name = "conference")
    private String conference;

    @Column(name = "division")
    private String division;


    public Team() {}

    public Team(String name, String city, String conference, String division) {
        this.name = name;
        this.city = city;
        this.conference = conference;
        this.division = division;
    }

    public Team(int id, String name, String city, String conference, String division, Coach coach) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.conference = conference;
        this.division = division;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getConference() {
        return conference;
    }

    public void setConference(String conference) {
        this.conference = conference;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }


    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", conference='" + conference + '\'' +
                ", division='" + division + '\'' +
                '}';
    }
}
