package com.example.userservicejwtsecurity;

import com.example.userservicejwtsecurity.entities.AppRole;
import com.example.userservicejwtsecurity.entities.AppUser;
import com.example.userservicejwtsecurity.services.Userservice;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class UserServiceJwtSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserServiceJwtSecurityApplication.class, args);
    }

    @Bean
    CommandLineRunner start(Userservice userservice){
        return  args -> {
            userservice.saveRole(new AppRole(null,"ROLE_ADMIN"));
            userservice.saveRole(new AppRole(null,"ROLE_USER"));

            userservice.saveUser(new AppUser(null, "mohamed", "1234", new ArrayList<>()));
          userservice.saveUser(new AppUser(null, "adam", "1234",  new ArrayList<>()));
          userservice.saveUser(new AppUser(null, "halima", "1234",  new ArrayList<>()));
          userservice.saveUser(new AppUser(null, "hicham", "1234",  new ArrayList<>()));
          userservice.saveUser(new AppUser(null, "saloi", "1234",  new ArrayList<>()));


          userservice.addRoleToUser("mohamed", "ROLE_ADMIN");
          userservice.addRoleToUser("adam", "ROLE_ADMIN");
          userservice.addRoleToUser("halima", "ROLE_USER");
          userservice.addRoleToUser("hicham", "ROLE_USER");
          userservice.addRoleToUser("saloi", "ROLE_USER");
        };
    }

}
