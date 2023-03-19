package com.softuni.toolmarket.service;

import com.softuni.toolmarket.model.dto.UserRegistrationDTO;

public interface UserService {

    void initUserRoles();
    void initUsers();
    void createAccount (UserRegistrationDTO userRegistrationDTO);


}
