package com.example.userservicejwtsecurity.services;

import com.example.userservicejwtsecurity.entities.AppRole;
import com.example.userservicejwtsecurity.entities.AppUser;
import com.example.userservicejwtsecurity.repositories.RoleRepository;
import com.example.userservicejwtsecurity.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class UserserviceImpl implements Userservice, UserDetailsService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;



    @Override
    public AppUser saveUser(AppUser appUser) {
        appUser.setId(UUID.randomUUID().toString());
        return userRepository.save(appUser);
    }

    @Override
    public AppRole saveRole(AppRole appRole) {
        appRole.setId(UUID.randomUUID().toString());
        return roleRepository.save(appRole);
    }

    @Override
    public void addRoleToUser(String userName, String roleName) {
        AppRole role = roleRepository.findByRoleName(roleName);
        AppUser user = userRepository.findByUserName(userName);
        user.getRoles().add(role);
    }

    @Override
    public AppUser getUserByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    @Override
    public List<AppUser> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser user = getUserByUserName(username);

        if(user == null)
            throw new UsernameNotFoundException("User not found");

        Collection<GrantedAuthority> authorities = new ArrayList<>();
        user.getRoles()
                .forEach(role -> {
                    authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
                });

        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), authorities);
    }
}
