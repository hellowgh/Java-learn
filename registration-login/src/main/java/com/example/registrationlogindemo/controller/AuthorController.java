package com.example.registrationlogindemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthorController {

    @GetMapping("/index")
    public String home() {
        return "index";
    }

}
