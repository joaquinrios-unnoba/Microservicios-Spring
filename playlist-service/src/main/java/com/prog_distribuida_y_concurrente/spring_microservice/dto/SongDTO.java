package com.prog_distribuida_y_concurrente.spring_microservice.dto;

public class SongDTO {
    private Long id;
    private String name;

    public SongDTO() { }

    public SongDTO(Long id, String name) {
        this.id = id;
        this.name = name;
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
}
