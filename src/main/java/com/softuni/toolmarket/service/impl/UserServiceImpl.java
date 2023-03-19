package com.softuni.toolmarket.service.impl;

import com.softuni.toolmarket.model.dto.UserRegistrationDTO;
import com.softuni.toolmarket.model.entity.UserEntity;
import com.softuni.toolmarket.model.entity.UserRoleEntity;
import com.softuni.toolmarket.model.repository.UserRepository;
import com.softuni.toolmarket.model.repository.UserRoleRepository;
import com.softuni.toolmarket.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.softuni.toolmarket.model.enums.UserRoleEnum.*;

@Service
public class UserServiceImpl implements UserService {

    private final UserDetailsService userDetailsService;
    private final UserRoleRepository userRoleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final String defaultPassword ;


    public UserServiceImpl(UserDetailsService userDetailsService, UserRoleRepository userRoleRepository
            , UserRepository userRepository, PasswordEncoder passwordEncoder
            ,@Value("${app.default.password}") String defaultPassword) {

        this.userDetailsService = userDetailsService;
        this.userRoleRepository = userRoleRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.defaultPassword = defaultPassword;
    }

    @Override
    public void initUserRoles() {

        if (userRoleRepository.count() == 0){

            UserRoleEntity adminRole = new UserRoleEntity().setRole(ADMIN);
            UserRoleEntity userRole = new UserRoleEntity().setRole(USER);
            UserRoleEntity companyRole= new UserRoleEntity().setRole(COMPANY);

            userRoleRepository.saveAll(List.of(adminRole, userRole, companyRole));
        }

    }

    @Override
    public void initUsers() {
        if (userRepository.count()==0){
            UserEntity adminUser = new UserEntity()
                    .setUserName("Admin")
                    .setEmail("aladin@abv.bg")
                    .setIdentificationNumber("12345")
                    .setPassword(passwordEncoder.encode(defaultPassword))
                    .setRoles(userRoleRepository.findAll());

            UserRoleEntity userRole= userRoleRepository.findByRole(USER)
                    .orElseThrow(() -> new IllegalStateException(" greshka v rolqta"));

            UserEntity normalUser = new UserEntity()
                    .setUserName("User")
                    .setEmail("vasil@abv.bg")
                    .setIdentificationNumber("8003234550")
                    .setPassword(passwordEncoder.encode(defaultPassword))
                    .setRoles(List.of(userRole));

            UserRoleEntity companyRole= userRoleRepository.findByRole(COMPANY)
                    .orElseThrow(() -> new IllegalStateException(" greshka v rolqta"));

            UserEntity companyUser = new UserEntity()
                    .setUserName("Company")
                    .setEmail("company@abv.bg")
                    .setIdentificationNumber("BG160015310")
                    .setPassword(passwordEncoder.encode(defaultPassword))
                    .setRoles(List.of(companyRole));




            userRepository.saveAll(List.of(adminUser, normalUser, companyUser));

        }


    }

    @Override
    public void createAccount(UserRegistrationDTO userRegistrationDTO) {

        UserEntity userEntity = new UserEntity();

        userEntity
                .setUserName(userRegistrationDTO.getUserName())
                .setIdentificationNumber(userRegistrationDTO.getIdentificationNumber())
                .setEmail(userRegistrationDTO.getEmail())
                .setPassword(passwordEncoder.encode( userRegistrationDTO.getPassword()));
        userRepository.save(userEntity);


        var userDetails = userDetailsService.loadUserByUsername(userRegistrationDTO.getEmail());
        Authentication authentication = new UsernamePasswordAuthenticationToken(
                userDetails,
                userDetails.getPassword(),
                userDetails.getAuthorities()
        );

        SecurityContextHolder.
                getContext().
                setAuthentication(authentication);
    }

}
