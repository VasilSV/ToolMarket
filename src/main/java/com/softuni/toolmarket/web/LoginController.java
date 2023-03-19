package com.softuni.toolmarket.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
@GetMapping("/users/login")
    public String login(){
        return "auth-login";
    }


}
