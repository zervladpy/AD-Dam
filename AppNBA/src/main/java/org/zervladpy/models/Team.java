package org.zervladpy.models;

import jakarta.persistence.*;

@Entity(name = "team")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teamId")
    int id;

    @Column(name = "name")
    String name;

    @Column(name = "city")
    String city;

    @Column(name = "conference")
    String conference;

    @Column(name = "division")
    String division;

    public Team() {
    }

    public Team(String name, String city, String conference, String division) {
        this.name = name;
        this.city = city;
        this.conference = conference;
        this.division = division;
    }

    public Team(int id, String name, String city, String conference, String division) {
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
