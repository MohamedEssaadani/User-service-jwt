package com.example.userservicejwtsecurity.web;

import com.example.userservicejwtsecurity.entities.AppRole;
import com.example.userservicejwtsecurity.entities.AppUser;
import com.example.userservicejwtsecurity.model.AddRoleToUserRequest;
import com.example.userservicejwtsecurity.services.Userservice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class UserController {
    private final Userservice userservice;

    public UserController(Userservice userservice) {
        this.userservice = userservice;
    }

    @PostMapping("/users")
    public ResponseEntity<AppUser> saveUser(@RequestBody AppUser user){
        return new ResponseEntity<>(userservice.saveUser(user), HttpStatus.CREATED);
    }

    @PostMapping("/roles")
    public ResponseEntity<AppRole> saveRole(@RequestBody AppRole role){
        return new ResponseEntity<>(userservice.saveRole(role), HttpStatus.CREATED);
    }


    @GetMapping("/users")
    public ResponseEntity<List<AppUser>> getAllUsers(){
        return new ResponseEntity<>(userservice.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/users/{username}")
    public ResponseEntity<AppUser> getUserByUserName(@PathVariable String username){
        return new ResponseEntity<>(userservice.getUserByUserName(username), HttpStatus.OK);
    }

    @PostMapping("/roles/add-to-user")
    public ResponseEntity<?> addRoleToUser(@RequestBody AddRoleToUserRequest form){
        userservice.addRoleToUser(form.getUserName(), form.getRoleName());

        return ResponseEntity.ok().build();
    }
}

