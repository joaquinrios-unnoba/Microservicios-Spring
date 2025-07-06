package com.prog_distribuida_y_concurrente.spring_microservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prog_distribuida_y_concurrente.spring_microservice.model.Playlist;
import com.prog_distribuida_y_concurrente.spring_microservice.repository.PlaylistRepository;

@Service
public class PlaylistServiceImpl implements PlaylistService {
    
    private PlaylistRepository playlistRepository;

    @Autowired
    public PlaylistServiceImpl(PlaylistRepository playlistRepository){
        this.playlistRepository = playlistRepository;
    }

    @Override
    public List<Playlist> getPlaylists(){
        return playlistRepository.findAll();
    }

    @Override
    public Playlist findById(Long id){
        return playlistRepository.findById(id).orElse(null);
    }
}
