package com.example.songer.models;

import lombok.*;
import javax.persistence.*;
import java.util.Set;

@Setter
@Getter
@RequiredArgsConstructor
@Entity
public class Albums {

    @Setter(value = AccessLevel.NONE )
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "id" , nullable = false)
    private long id;

    private String title;
    private String artist;
    private int songCount;
    private int length;
    private String imageUrl;

    @OneToMany(mappedBy = "album")
    Set<Song> songs;

    @Override
    public String toString() {
        return "Albums{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", songCount=" + songCount +
                ", length=" + length +
                ", imageUrl='" + imageUrl + '\'' +
                ", songs=" + songs +
                '}';
    }
}
