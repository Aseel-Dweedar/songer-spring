package com.example.songer.repos;

import com.example.songer.models.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface SongRepo extends JpaRepository<Song,Long> {
    Set<Song> findAllByAlbum_Id(Long id);
}
