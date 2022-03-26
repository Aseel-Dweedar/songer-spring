package com.example.songer.repos;

import com.example.songer.models.UserX;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserX,Long> {
    UserX findByUsername(String username);
}
