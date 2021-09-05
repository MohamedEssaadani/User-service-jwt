package com.example.userservicejwtsecurity.repositories;

import com.example.userservicejwtsecurity.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<AppUser, Long> {
    AppUser findByUserName(String username);
}
