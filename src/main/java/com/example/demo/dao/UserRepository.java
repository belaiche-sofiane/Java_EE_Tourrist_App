package com.example.demo.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUserName(String username);
	public User save(User user);
}
