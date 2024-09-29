package com.kangroklee.demo.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.FetchType.LAZY;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Playlist {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "playlist_id")
    private long id;

    private String title;
    private String desc;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "member_id")
    private Member owner;

    @ManyToMany(mappedBy = "playlists")
    private List<Song> songs = new ArrayList<>();
}
