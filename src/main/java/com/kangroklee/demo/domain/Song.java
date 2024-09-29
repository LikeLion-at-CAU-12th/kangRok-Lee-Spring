package com.kangroklee.demo.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Song {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "song_id")
    private long id;

    private String title;

    @ManyToOne
    @JoinColumn(name = "artist_id")
    private Artist artist;
    @ManyToOne
    @JoinColumn(name = "album_id")
    private Album album;

    @ManyToMany(mappedBy = "songs")
    private List<Genre> genres = new ArrayList<>();

    //Song -> Playlist로 ManyToMany 정의할 필요 있을까? 단방향으로만 둬도 되지 않을까?
    @ManyToMany
    private List<Playlist> playlists = new ArrayList<>();
}
