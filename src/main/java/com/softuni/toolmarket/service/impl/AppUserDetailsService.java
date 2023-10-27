package com.softuni.toolmarket.service.impl;
import com.softuni.toolmarket.model.entity.UserEntity;
import com.softuni.toolmarket.model.entity.UserRoleEntity;
import com.softuni.toolmarket.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class AppUserDetailsService implements UserDetailsService{
private final UserRepository userRepository;

    public AppUserDetailsService(UserRepository userRepository) {
        this.userRepository= userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findUserEntityByEmail(email).

                map(this::map).
                orElseThrow(() -> new UsernameNotFoundException("User with email " + email + " not found."));
    }


    private UserDetails map(UserEntity userEntity) {
        return new User(
                userEntity.getEmail(),
                userEntity.getPassword(),
                extractAuthorities(userEntity)
        );
    }

    private List<GrantedAuthority> extractAuthorities(UserEntity userEntity) {
        return userEntity.
                getRoles().
                stream().
                map(this::mapRole).
                toList();
    }
    private GrantedAuthority mapRole(UserRoleEntity userRoleEntity) {
        return new SimpleGrantedAuthority("ROLE_" + userRoleEntity.getRole().name());
    }

    public UserEntity getUserByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }
}
