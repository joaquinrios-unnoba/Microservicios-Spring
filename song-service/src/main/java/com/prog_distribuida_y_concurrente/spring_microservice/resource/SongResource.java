package com.prog_distribuida_y_concurrente.spring_microservice.resource;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.prog_distribuida_y_concurrente.spring_microservice.dto.SongDTO;
import com.prog_distribuida_y_concurrente.spring_microservice.model.Song;
import com.prog_distribuida_y_concurrente.spring_microservice.service.SongService;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/songs")
public class SongResource {

    @Autowired
    private SongService songService;

    @GetMapping
    public List<SongDTO> getSongs() {
        return songService.getSongs()
                .stream()
                .map(s -> new SongDTO(s.getId(), s.getName()))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public SongDTO getSong(@PathVariable Long id) {
        Song s = songService.findById(id);
        if (s == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Song not found");
        }
        return new SongDTO(s.getId(), s.getName());
    }
}
