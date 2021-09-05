package com.example.userservicejwtsecurity.services;

import com.example.userservicejwtsecurity.entities.AppRole;
import com.example.userservicejwtsecurity.entities.AppUser;

import java.util.List;

public interface Userservice {
    AppUser saveUser(AppUser appUser);
    AppRole saveRole(AppRole appRole);
    void addRoleToUser(String userName, String roleName);
    AppUser getUserByUserName(String userName);
    List<AppUser> getAllUsers();
}
