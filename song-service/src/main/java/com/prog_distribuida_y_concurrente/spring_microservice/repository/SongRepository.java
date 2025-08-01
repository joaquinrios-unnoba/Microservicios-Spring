package com.prog_distribuida_y_concurrente.spring_microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prog_distribuida_y_concurrente.spring_microservice.model.Song;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {

}
