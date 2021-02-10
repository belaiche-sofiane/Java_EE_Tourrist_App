package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.Celebrite;
import com.example.demo.entities.Departement;

public interface CelebriteDao extends JpaRepository<Celebrite,Integer> {
	@Query("select c from Celebrite c where c.nom=:x")
    public Celebrite getCelebrite(@Param("x") String nom);
}
