package com.prog_distribuida_y_concurrente.spring_microservice.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.prog_distribuida_y_concurrente.spring_microservice.model.Song;
import com.prog_distribuida_y_concurrente.spring_microservice.service.SongService;

@Controller
@RequestMapping("/songs")
public class SongResource {

    private SongService songService;

    @Autowired
    public SongResource(SongService songService){
        this.songService = songService;
    }

    @GetMapping
    public List<Song> getSongs(){
        return songService.getSongs();
    }

    @GetMapping("/{id}")
    public Song getSong(@PathVariable("id") Long songId){
        return songService.findById(songId);
    }


    
}
