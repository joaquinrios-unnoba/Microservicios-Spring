package com.prog_distribuida_y_concurrente.spring_microservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prog_distribuida_y_concurrente.spring_microservice.model.Song;
import com.prog_distribuida_y_concurrente.spring_microservice.repository.SongRepository;

@Service
public class SongServiceImpl implements SongService{

    private SongRepository songRepository;

    @Autowired
    public SongServiceImpl(SongRepository songRepository){
        this.songRepository = songRepository;
    }

    @Override
    public List<Song> getSongs(){
        return songRepository.findAll();
    }
    
    @Override
    public Song findById(Long id){
        return songRepository.findById(id).orElse(null);
    }
}
