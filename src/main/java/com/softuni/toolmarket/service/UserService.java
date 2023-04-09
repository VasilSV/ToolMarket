package com.softuni.toolmarket.service;

import com.softuni.toolmarket.model.dto.UserRegistrationDTO;
import org.springframework.security.core.Authentication;


import java.util.function.Consumer;

public interface UserService  {

    void initUserRoles();
    void initUsers();
    void createAccount (UserRegistrationDTO userRegistrationDTO,
                        Consumer<Authentication> successfulLoginProcessor);



}
