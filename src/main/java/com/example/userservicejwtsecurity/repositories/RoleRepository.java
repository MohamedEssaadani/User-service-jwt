package com.example.userservicejwtsecurity.repositories;

import com.example.userservicejwtsecurity.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<AppRole, Long> {
    AppRole findByRoleName(String roleName);
}
