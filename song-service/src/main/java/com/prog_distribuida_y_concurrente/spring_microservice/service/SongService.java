package com.prog_distribuida_y_concurrente.spring_microservice.service;

import java.util.List;

import com.prog_distribuida_y_concurrente.spring_microservice.model.Song;

public interface SongService {

    public List<Song> getSongs();
    public Song findById(Long id);
}
