package com.example.springbootdemo.controllers;

import com.example.springbootdemo.entity.UserEntity;
import com.example.springbootdemo.models.User;
import com.example.springbootdemo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(path = "/api/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

//    @GetMapping
//    public String getUsers() {
//        return "Hello! user";
//    }

    @GetMapping
    public List<UserEntity> getUsers() {
//        return Arrays.asList(
//                new User(1, "Rinos", "rns@gmail.com"),
//                new User(2, "Rosy", "ros@gmail.com"),
//                new User(3, "Mohamed", "mhd@gmail.com")
//        );
        return userRepository.findAll();
    }

}
