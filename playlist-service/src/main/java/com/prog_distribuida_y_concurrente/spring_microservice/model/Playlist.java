package com.prog_distribuida_y_concurrente.spring_microservice.model;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name="playlist")
public class Playlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long Id;

    private String name;

    @OneToMany(mappedBy = "playlist")
    private List<PlaylistSong> playlistSongs;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PlaylistSong> getPlaylistSongs() {
        return playlistSongs;
    }

    public void setPlaylistSongs(List<PlaylistSong> playlistSongs) {
        this.playlistSongs = playlistSongs;
    }
  
}
