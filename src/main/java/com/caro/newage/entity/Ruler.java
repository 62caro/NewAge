package com.caro.newage.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Ruler {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int age;

    @OneToMany(mappedBy = "ruler", cascade = CascadeType.ALL)
    private Set<Planet> planet;

    public Ruler(){}

    public Ruler(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Set<Planet> getPlanet() {
        return planet;
    }

    public void setPlanet(Set<Planet> planet) {
        this.planet = planet;
    }
}
