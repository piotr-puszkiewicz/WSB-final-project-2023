package com.example.wsbfinalproject2023.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String index() {
        return "security/login";
    }
}

