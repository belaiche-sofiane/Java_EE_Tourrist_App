package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Lieu;

public interface LieuDao extends JpaRepository<Lieu, String> {

}
