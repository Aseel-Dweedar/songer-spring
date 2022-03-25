package com.example.songer.models;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@RequiredArgsConstructor
@Entity
public class Song {

    @Setter(value = AccessLevel.NONE )
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "id" , nullable = false)
    private long id;

    private String title;
    private int length;

    @ManyToOne
    Albums album;

    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", length=" + length +
                ", album=" + album +
                '}';
    }
}
