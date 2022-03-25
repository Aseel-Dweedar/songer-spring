package com.example.songer.services;

import com.example.songer.models.Albums;
import com.example.songer.models.Song;
import com.example.songer.repos.SongRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class SongsService {

    private final SongRepo songRepo;

    @Autowired
    public SongsService(SongRepo songRepo) {
        this.songRepo=songRepo;
    }

    public List<Song> getAllSongs() {
        return songRepo.findAll();
    }

    public Set<Song> findSongsByAlbumId(Long id) {
        return songRepo.findAllByAlbum_Id(id);
    }

    public void addSong(Song song , Albums album) {
        song.setAlbum(album);
        songRepo.save(song);
    }
}
