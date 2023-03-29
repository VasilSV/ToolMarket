package com.softuni.toolmarket.web;

import ch.qos.logback.core.model.Model;
import com.softuni.toolmarket.service.impl.AppUserDetailsService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PagesController{

    @GetMapping("/")
    public String home(){

        return "index";
    }

    @GetMapping("/pages/all")
    public String all() {
        return "all";
    }

    @GetMapping("/pages/admins")
    public String admins() {
        return "admins";
    }

    @GetMapping("/pages/users")
    public String users() {
        return "users";
    }

    @GetMapping("/pages/company")
    public String company() {
        return "company";
    }


}
