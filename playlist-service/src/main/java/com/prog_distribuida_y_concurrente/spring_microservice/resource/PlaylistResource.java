package com.prog_distribuida_y_concurrente.spring_microservice.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.prog_distribuida_y_concurrente.spring_microservice.model.Playlist;
import com.prog_distribuida_y_concurrente.spring_microservice.service.PlaylistService;

@Controller
@RequestMapping("/playlists")
public class PlaylistResource {

    private PlaylistService playlistService;

    @Autowired
    public PlaylistResource(PlaylistService playlistService){
        this.playlistService = playlistService;
    }

    @GetMapping
    public List<Playlist> getPlaylists(){
        return playlistService.getPlaylists();
    }

    @GetMapping("/(id)")
    public Playlist gePlaylist(@PathVariable("id") Long id){ //D. Se debe incluir en la respuesta el listado de todas las canciones (id y nombre) que se incluyen en la playlist.

        return playlistService.findById(id);
    }

}
