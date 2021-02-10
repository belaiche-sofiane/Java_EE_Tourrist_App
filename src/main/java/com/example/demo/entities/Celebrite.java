package com.example.demo.entities;
import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity

public class Celebrite implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id 
	private Integer numCelebrite;
	
	@Column(length=16)
	private String nom;
	@Column(length=16)
	private String prenom;
	@Column(length=10)
	private String nationalite;
	@Column(length=6)
	private String epoque;
	
	@ManyToMany(mappedBy ="celebrites",fetch = FetchType.EAGER) 
	  private List<Monument> codeM;

       public Celebrite() {
		super();
	}


	public Celebrite(Integer numCelebrite, String nom, String prenom, String nationalite, String epoque) {
		super();
		this.numCelebrite = numCelebrite;
		this.nom = nom;
		this.prenom = prenom;
		this.nationalite = nationalite;
		this.epoque = epoque;
		
	}


	public Integer getNumCelebrite() {
		return numCelebrite;
	}


	public void setNumCelebrite(Integer numCelebrite) {
		this.numCelebrite = numCelebrite;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getNationalite() {
		return nationalite;
	}


	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}


	public String getEpoque() {
		return epoque;
	}


	public void setEpoque(String epoque) {
		this.epoque = epoque;
	}


	public List<Monument> getCodeM() {
		return codeM;
	}


	public void setCodeM(List<Monument> codeM) {
		this.codeM = codeM;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	
		
	

	}

	
	
	
	
	
	
	
	
	
	
	
	


