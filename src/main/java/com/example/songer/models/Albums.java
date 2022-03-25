package com.example.songer.models;

import lombok.*;
import javax.persistence.*;

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

}
