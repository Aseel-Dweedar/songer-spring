package com.example.songer.services;

import com.example.songer.models.Albums;
import com.example.songer.repos.AlbumsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumsServices {

    private final AlbumsRepo albumsRepo;

    @Autowired
    public AlbumsServices(AlbumsRepo albumsRepo) {
        this.albumsRepo = albumsRepo;
    }

    public List<Albums> getAllAlbums() {
        List<Albums> albums = albumsRepo.findAll();
        return albums;
    }

    public Albums addAlbum(Albums album) {
        albumsRepo.save(album);
        return album;
    }

}
