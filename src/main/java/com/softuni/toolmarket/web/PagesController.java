package com.softuni.toolmarket.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PagesController {

    @GetMapping("pages/all")
    public String all(){
        return "all";
    }


}
