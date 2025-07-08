package com.prog_distribuida_y_concurrente.spring_microservice.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.prog_distribuida_y_concurrente.spring_microservice.dto.PlaylistDTO;
import com.prog_distribuida_y_concurrente.spring_microservice.service.PlaylistService;

@RestController
@RequestMapping("/playlists")
public class PlaylistResource {

    @Autowired
    private PlaylistService playlistService;

    @GetMapping
    public List<PlaylistDTO> getPlaylists() {
        return playlistService.getPlaylists();
    }

    @GetMapping("/{id}")
    public PlaylistDTO getPlaylist(@PathVariable Long id) {
        return playlistService.findById(id);
    }
}
