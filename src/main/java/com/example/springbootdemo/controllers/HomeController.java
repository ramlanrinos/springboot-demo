package com.example.springbootdemo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping
    public String getHomePage() {
        return "Welcome to Spring Boot Demo";
    }

    @GetMapping("/dashboard")
    public String getDashboardPage() {
        return "Login successful";
    }
}
