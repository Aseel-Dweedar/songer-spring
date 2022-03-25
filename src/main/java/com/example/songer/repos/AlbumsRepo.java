package com.example.songer.repos;

import com.example.songer.models.Albums;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumsRepo extends JpaRepository<Albums,Long> {
}
