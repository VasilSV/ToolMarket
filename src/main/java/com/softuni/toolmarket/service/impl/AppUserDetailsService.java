package com.softuni.toolmarket.service.impl;
import com.softuni.toolmarket.model.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class AppUserDetailsService implements UserDetailsService{
private final UserRepository userRepository;

    public AppUserDetailsService(UserRepository userRepository) {
        this.userRepository= userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
