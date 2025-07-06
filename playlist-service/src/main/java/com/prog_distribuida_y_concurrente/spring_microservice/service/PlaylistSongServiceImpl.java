package com.prog_distribuida_y_concurrente.spring_microservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prog_distribuida_y_concurrente.spring_microservice.model.PlaylistSong;
import com.prog_distribuida_y_concurrente.spring_microservice.repository.PlaylistSongRepository;

@Service
public class PlaylistSongServiceImpl implements PlaylistSongService {

    private PlaylistSongRepository playlistSongRepository;

    @Autowired
    public PlaylistSongServiceImpl (PlaylistSongRepository playlistSongRepository){
        this.playlistSongRepository = playlistSongRepository;
    }

    @Override
    public List<PlaylistSong> getPlaylistSongs(){
        return playlistSongRepository.findAll();
    }

    @Override
    public PlaylistSong findById(Long id){
        return playlistSongRepository.findById(id).orElse(null);
    }
}
