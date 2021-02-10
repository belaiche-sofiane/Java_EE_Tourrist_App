package com.example.demo.dao;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.Monument;

public interface MonumentDao extends JpaRepository<Monument, String>{
	@Query("select m from Monument m where m.nomM like:x")
    public List<Monument> FindMonument(@Param("x") String mc);

   @Query("select m from Monument m where m.codeM=:x")
    public Monument getMonument(@Param("x") String codeM);
}
