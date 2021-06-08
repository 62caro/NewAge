package com.caro.newage.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Planet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne(cascade = CascadeType.REFRESH)
    private Ruler ruler;

    public Planet(){}

    public Planet(String name) {
        this.name = name;
    }

    public Planet(String name, Ruler ruler) {
        this.name = name;
        this.ruler = ruler;
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

    public Ruler getRuler() {
        return ruler;
    }

    public void setRuler(Ruler ruler) {
        this.ruler = ruler;
    }
}
