package com.prog_distribuida_y_concurrente.spring_microservice.model;


import jakarta.persistence.*;

@Entity
@Table(name = "playlist_song")
public class PlaylistSong {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "playlist_id", referencedColumnName = "id")
    private Playlist playlist;

    @Column(name = "song_id")
    private Long songId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Playlist getPlaylist() {
        return playlist;
    }

    public void setPlaylist(Playlist playlist) {
        this.playlist = playlist;
    }

    public Long getSongId() {
        return songId;
    }

    public void setSongId(Long songId) {
        this.songId = songId;
    }

}
