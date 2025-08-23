package com.example.springbootdemo.controllers;

import com.example.springbootdemo.entity.UserEntity;
import com.example.springbootdemo.exceptions.ResourceNotFoundException;
import com.example.springbootdemo.models.User;
import com.example.springbootdemo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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

    @PostMapping
    public UserEntity createUser(@RequestBody UserEntity user) {
        return userRepository.save(user);
    }

    @GetMapping("/{id}")
    public UserEntity getUser(@PathVariable int id) {
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with this id: " + id));
    }

    @PutMapping("/{id}")
    public UserEntity updateUser (@PathVariable int id, @RequestBody UserEntity user) {
        UserEntity userdata = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with this id: " + id));
        userdata.setUsername(user.getUsername());
        userdata.setEmail(user.getEmail());
        return userRepository.save(userdata);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id) {
        UserEntity userdata = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with this id: " + id));
        userRepository.delete(userdata);
    }
}
