package com.example.userservicejwtsecurity.model;

import lombok.Data;

@Data
public class AddRoleToUserRequest {
    private String userName;
    private String roleName;
}
