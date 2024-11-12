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
    public Member(String name, String username, String password, String email, Integer age) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.created_at = LocalDateTime.now();
        this.age = age;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(nullable = false)
    private String username;

    private String name;
    private String email;
    private String password;
    private LocalDateTime created_at;
    private int age;

    @OneToMany(mappedBy = "owner")
    private List<Playlist> myPlaylists = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<Like> myLikes = new ArrayList<>();

}