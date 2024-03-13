package com.zervladpy.springperson;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static jakarta.persistence.GenerationType.IDENTITY;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
@Entity(name ="person")
public class Person {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }
}
