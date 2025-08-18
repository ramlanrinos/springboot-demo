package com.example.springbootdemo.controllers;

import com.example.springbootdemo.models.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(path = "/api/users")
public class UserController {
//    @GetMapping
//    public String getUsers() {
//        return "Hello! user";
//    }

    @GetMapping
    public List<User> getUsers() {
        return Arrays.asList(
                new User(1, "Rinos", "rns@gmail.com"),
                new User(2, "Rosy", "ros@gmail.com")
        );
    }


}
