package com.example.springbootdemo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String email;

    public UserEntity() {
        super();
    }

    public UserEntity(int id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }
}
