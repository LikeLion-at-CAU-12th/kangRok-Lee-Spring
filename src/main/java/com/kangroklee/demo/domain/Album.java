package com.kangroklee.demo.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Album {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "album_id")
    private long id;

    private String title;
    private LocalDateTime released_at;
    @ManyToOne
    @JoinColumn(name = "artist_id")
    private Artist artist;
    @OneToMany(mappedBy = "album")
    private List<Song> songs = new ArrayList<>();
}
