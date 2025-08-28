package com.example.springbootdemo.repositories;

import com.example.springbootdemo.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    // JpaRepository query by the given column name (userName)
    Optional<UserEntity> findByUserName(String username);
}
