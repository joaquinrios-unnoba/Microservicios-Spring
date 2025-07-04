package com.prog_distribuida_y_concurrente.spring_microservice.model;

import jakarta.persistence.*;

@Entity
@Table(name = "song")
public class Song {

     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

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
}
