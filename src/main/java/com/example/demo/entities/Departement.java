package com.example.demo.entities;
import java.beans.Transient;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;




@Entity
public class Departement implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(length=4)
	private String dep;
	@Column(length=46)
	private String chefLieu;
	@Column(length=30)
	private String nomDep;
	@Column(length=5)
	private String numReg;
	
	
	//un a plusieurs
	@OneToMany(mappedBy="dep", fetch=FetchType.LAZY)
	private Collection<Lieu> lieux;


	public Departement() {
		super();
	}

	public Departement(String dep, String chefLieu, String nomDep, String numReg) {
		super();
		this.dep = dep;
		this.chefLieu = chefLieu;
		this.nomDep = nomDep;
		this.numReg = numReg;
		
	}




	public String getDep() {
		return dep;
	}


	public void setDep(String dep) {
		this.dep = dep;
	}


	public String getChefLieu() {
		return chefLieu;
	}


	public void setChefLieu(String chefLieu) {
		this.chefLieu = chefLieu;
	}


	public String getNomDep() {
		return nomDep;
	}


	public void setNomDep(String nomDep) {
		this.nomDep = nomDep;
	}


	public String getNumReg() {
		return numReg;
	}


	public void setNumReg(String numReg) {
		this.numReg = numReg;
	}


	public Collection<Lieu> getLieux() {
		return lieux;
	}


	public void setLieux(Collection<Lieu> lieux) {
		this.lieux = lieux;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	


}
