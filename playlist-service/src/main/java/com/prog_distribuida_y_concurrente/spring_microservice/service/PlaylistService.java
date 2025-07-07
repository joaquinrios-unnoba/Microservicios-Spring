package com.prog_distribuida_y_concurrente.spring_microservice.service;

import java.util.List;
import com.prog_distribuida_y_concurrente.spring_microservice.dto.PlaylistDTO;

public interface PlaylistService {
    List<PlaylistDTO> getPlaylists();
    PlaylistDTO findById(Long id);
}
