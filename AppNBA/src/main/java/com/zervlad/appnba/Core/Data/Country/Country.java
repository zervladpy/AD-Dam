package com.zervlad.appnba.Core.Data.Country;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "countries")
public class Country {
    @Id
    private int id;
    @Column(name = "name")
    private String name;
}
