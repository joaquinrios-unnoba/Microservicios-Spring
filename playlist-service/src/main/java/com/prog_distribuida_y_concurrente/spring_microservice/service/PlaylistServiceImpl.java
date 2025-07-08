package com.prog_distribuida_y_concurrente.spring_microservice.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.prog_distribuida_y_concurrente.spring_microservice.dto.PlaylistDTO;
import com.prog_distribuida_y_concurrente.spring_microservice.dto.SongDTO;
import com.prog_distribuida_y_concurrente.spring_microservice.model.Playlist;
import com.prog_distribuida_y_concurrente.spring_microservice.model.PlaylistSong;
import com.prog_distribuida_y_concurrente.spring_microservice.repository.PlaylistRepository;
import com.prog_distribuida_y_concurrente.spring_microservice.repository.PlaylistSongRepository;

@Service
public class PlaylistServiceImpl implements PlaylistService {

    @Autowired
    private PlaylistRepository playlistRepository;

    @Autowired
    private PlaylistSongRepository playlistSongRepository;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public PlaylistDTO findById(Long id) {
        Playlist pl = playlistRepository.findById(id).orElse(null);
        if (pl == null) return null;

        // Obtengo relaciones
        List<PlaylistSong> links = playlistSongRepository.findAll()
                .stream()
                .filter(ps -> ps.getPlaylist().getId().equals(id))
                .collect(Collectors.toList());

        // Descubro song-service
        String baseUrl = discoveryClient.getInstances("song-service")
                .stream()
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("No song-service"))
                .getUri()
                .toString();

        // Mapeo cada PlaylistSong → SongDTO
        List<SongDTO> songs = links.stream()
                .map(ps -> restTemplate.getForObject(
                        baseUrl + "/songs/" + ps.getSongId(), SongDTO.class))
                .collect(Collectors.toList());

        // Devuelvo PlaylistDTO
        return new PlaylistDTO(pl.getId(), pl.getName(), songs);
    }

    @Override
    public List<PlaylistDTO> getPlaylists() {
        return playlistRepository.findAll()
                .stream()
                .map(pl -> findById(pl.getId()))
                .collect(Collectors.toList());
    }
}
