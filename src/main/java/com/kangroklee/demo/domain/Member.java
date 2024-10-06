package com.kangroklee.demo.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Member {
    @Builder
    public Member(String name, String username, String email, Integer age) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.created_at = LocalDateTime.now();
        this.age = age;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private long id;

    @Column(nullable = false)
    private String username;

    private String name;
    private String email;
    private LocalDateTime created_at;
    private int age;

    @OneToMany(mappedBy = "owner")
    private List<Playlist> myPlaylists = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<Like> myLikes = new ArrayList<>();

}