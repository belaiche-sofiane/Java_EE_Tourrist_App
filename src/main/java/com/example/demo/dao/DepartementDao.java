package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.Departement;


public interface DepartementDao extends JpaRepository<Departement,String>{
	 @Query("select d from Departement d where d.dep=:x")
	 public Departement getDepartement(@Param("x") String dep);
}
