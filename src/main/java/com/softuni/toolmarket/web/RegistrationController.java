package com.softuni.toolmarket.web;

import com.softuni.toolmarket.model.dto.UserRegistrationDTO;
import com.softuni.toolmarket.model.repository.UserRepository;
import com.softuni.toolmarket.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {
    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/register")
    public String register() {
        return "auth-register";
    }

    @PostMapping("/users/register")
    public String createAccount(UserRegistrationDTO userRegistrationDTO) {

        userService.createAccount(userRegistrationDTO);

        return "redirect:/";
    }
}


