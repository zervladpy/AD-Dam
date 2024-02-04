package org.zervladpy.models;

import jakarta.persistence.*;

@Entity(name = "coach")
public class Coach {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="coachId")
    int id;

    @Column(name = "name")
    String name;

    @Column(name = "bday")
    String birthday;

    @Column(name = "salary")
    Double salary;

    @OneToOne()
    @JoinColumn(name = "idTeam")
    Team team;

    public Coach() {}

    public Coach(int id, String name, String birthday, Double salary, Team team) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.salary = salary;
        this.team = team;
    }

    public Coach(String name, String birthday, Double salary, Team team) {
        this.name = name;
        this.birthday = birthday;
        this.salary = salary;
        this.team = team;
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    @Override
    public String toString() {
        return "Coach{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthday='" + birthday + '\'' +
                ", salary=" + salary +
                ", team=" + team +
                '}';
    }
}
