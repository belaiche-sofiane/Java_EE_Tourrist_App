package com.example.demo.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;




@Entity
public class Lieu implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@Column(length=5)
	private String codeInsee;
	
	
	@Column(length=46)
	private String nomCom;
	private double longitude;
	private double latitude;
	
	
	  @ManyToOne //plusieurs à un
	  
	  @JoinColumn(name="fk_dep")
	
	private Departement dep;
	
	@OneToMany(mappedBy="codeLieu",fetch=FetchType.LAZY)
	private Collection <Monument>Monuments;

	

	public Lieu() {
		super();
	}

	public Lieu(String codeInsee, String nomCom, double longitude, double latitude, Departement dep) {
		super();
		this.codeInsee = codeInsee;
		this.nomCom = nomCom;
		this.longitude = longitude;
		this.latitude = latitude;
		this.dep = dep;
		
	}

	public String getCodeInsee() {
		return codeInsee;
	}

	public void setCodeInsee(String codeInsee) {
		this.codeInsee = codeInsee;
	}

	public String getNomCom() {
		return nomCom;
	}

	public void setNomCom(String nomCom) {
		this.nomCom = nomCom;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public Departement getDep() {
		return dep;
	}

	public void setDep(Departement dep) {
		this.dep = dep;
	}

	public Collection<Monument> getMonuments() {
		return Monuments;
	}

	public void setMonuments(Collection<Monument> monuments) {
		Monuments = monuments;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Lieu [codeInsee=" + codeInsee + ", nomCom=" + nomCom + ", longitude=" + longitude + ", latitude="
				+ latitude + ", dep=" + dep + ", Monuments=" + Monuments + "]";
	}
	
	
	

	
	

}
