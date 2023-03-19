package com.softuni.toolmarket.init;

import com.softuni.toolmarket.service.UserService;
import org.springframework.boot.CommandLineRunner;

public class UserInit implements CommandLineRunner {
    private final UserService userService;

    public UserInit(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        userService.initUserRoles();
        userService.initUsers();

    }
}
