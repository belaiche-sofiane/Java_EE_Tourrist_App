package com.example.demo.metier;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.example.demo.entities.Celebrite;
import com.example.demo.entities.Departement;
import com.example.demo.entities.Lieu;
import com.example.demo.entities.Monument;
import com.example.demo.entities.User;

public interface IMetier {

public Celebrite save(Celebrite c);
public List<Celebrite> findAllCelebrite();
public Monument save(Monument m);
public List<Monument> findAllMonument();
public String deleteCelebrite(Integer numCelebrite);
public String deleteMonument(String codeM);
public double CalculDistanceEntreMonuments(String CodeMA, String CodeMB);
public Monument findMonumentByNom(String nomM);
public Departement save(Departement d);
public List<Departement> findAllDepartement();
public String deletedepartement(String dep);
public Lieu save(Lieu l);
public List<Lieu> findAllLieu();
public String deletelieu(String codeInsee);
public void AddCelebriteToMonument(Integer numCelebrite, String CodeM);
public Collection<Celebrite> GetCelebriteByMonument(String codeM);
public Collection<Monument> GetMonumentByDepartement(String dep);
public Collection<Monument> GetMonumentByCelebrite(String nom);
}
