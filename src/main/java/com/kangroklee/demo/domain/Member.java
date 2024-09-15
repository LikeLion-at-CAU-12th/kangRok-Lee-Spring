package com.kangroklee.demo.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Member {
    public Member() {
        this.name = name;
        this.email = email;
        this.created_at = LocalDateTime.now();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private long id;

    private String name;
    private String email;
    private LocalDateTime created_at;

    @OneToMany(mappedBy = "owner")
    private List<Playlist> myPlaylists = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<Like> myLikes = new ArrayList<>();

}