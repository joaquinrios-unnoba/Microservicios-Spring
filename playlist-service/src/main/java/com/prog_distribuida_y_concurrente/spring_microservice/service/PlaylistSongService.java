package com.prog_distribuida_y_concurrente.spring_microservice.service;

import java.util.List;

import com.prog_distribuida_y_concurrente.spring_microservice.model.PlaylistSong;

public interface PlaylistSongService {

    public List<PlaylistSong> getPlaylistSongs();
    public PlaylistSong findById(Long id);
}
