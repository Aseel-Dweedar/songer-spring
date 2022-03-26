package com.example.songer.models;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Setter
@Getter
@RequiredArgsConstructor
@Entity
public class UserX {

    @Setter(value = AccessLevel.NONE )
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "id" , nullable = false)
    private long id;

    private String username;
    private String password;

}
