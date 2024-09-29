package com.kangroklee.demo.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Artist {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "artist_id")
    private long id;

    private String name;

    @OneToMany(mappedBy = "artist")
    private List<Song> songs = new ArrayList<>();
    @OneToMany(mappedBy = "artist")
    private List<Album> albums = new ArrayList<>();
}
