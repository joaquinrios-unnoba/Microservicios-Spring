package com.prog_distribuida_y_concurrente.spring_microservice.service;

import java.util.List;

import com.prog_distribuida_y_concurrente.spring_microservice.model.Playlist;

public interface PlaylistService {

    public List<Playlist> getPlaylists();
    public Playlist findById(Long id);
}
