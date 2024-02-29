package com.zervlad.appnba.Core.Local.Entities;

import jakarta.persistence.*;

@Entity(name = "team")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "abbreviation")
    private String abbreviation;
    @Column(name = "city")
    private String city;
    @Column(name = "conference")
    private String conference;
    @Column(name = "division")
    private String division;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "name")
    private String name;
    @Column(name = "image")
    @Lob
    @Basic(fetch = FetchType.LAZY)
    private String image;
}
