package com.example.demo.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;



@Entity
public class Monument implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(length=5)
	private String codeM;
	@Column(length=25)
	private String nomM;
	@Column(length=10)
	private String proprietaire;
	@Column(length=16)
	private String typeMonument;
	@Column(length=16)
	private double latitude;
	@Column(length=16)
	private double longitude;
	
	@ManyToOne
	@JoinColumn(name="FK_CodeInsee")
	private Lieu codeLieu;
	
	
	  @ManyToMany
	  
	  @JoinTable(name="AssocieA",joinColumns=
	  
	  @JoinColumn(name="codeM"),
	  inverseJoinColumns=@JoinColumn(name="codecelebrites")) 
	  private List<Celebrite> celebrites;


	public Monument() {
		super();
	}


	public Monument(String codeM, String nomM, String proprietaire, String typeMonument, double latitude,
			double longitude, Lieu codeLieu) {
		super();
		this.codeM = codeM;
		this.nomM = nomM;
		this.proprietaire = proprietaire;
		this.typeMonument = typeMonument;
		this.latitude = latitude;
		this.longitude = longitude;
		this.codeLieu = codeLieu;
		
	}


	public String getCodeM() {
		return codeM;
	}


	public void setCodeM(String codeM) {
		this.codeM = codeM;
	}


	public String getNomM() {
		return nomM;
	}


	public void setNomM(String nomM) {
		this.nomM = nomM;
	}


	public String getProprietaire() {
		return proprietaire;
	}


	public void setProprietaire(String proprietaire) {
		this.proprietaire = proprietaire;
	}


	public String getTypeMonument() {
		return typeMonument;
	}


	public void setTypeMonument(String typeMonument) {
		this.typeMonument = typeMonument;
	}


	public double getLatitude() {
		return latitude;
	}


	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}


	public double getLongitude() {
		return longitude;
	}


	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}


	public Lieu getCodeLieu() {
		return codeLieu;
	}


	public void setCodeLieu(Lieu codeLieu) {
		this.codeLieu = codeLieu;
	}


	public List<Celebrite> getCelebrites() {
		return celebrites;
	}


	public void setCelebrites(List<Celebrite> Celebrite) {
		this.celebrites = Celebrite;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
		
		
	  
	  
	  
	
	

}
