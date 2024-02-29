package com.zervlad.appnba.Core.Local.Entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "position")
    private String position;
    @ManyToOne
    @Column(name = "team")
    private Team team;
    @Column(name = "image")
    @Lob
    @Basic(fetch = FetchType.LAZY)
    private String image;
    @Column(name = "jersey_number")
    private int jerseyNumber;
    @Column(name = "college_name")
    private String collegeName;
    @Column(name = "country")
    private String country;
    // @Column(name = "draft")
    // private Draft draft;
    @Column(name = "date_birth")
    private LocalDateTime dateBirth;
}
