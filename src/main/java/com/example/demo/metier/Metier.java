package com.example.demo.metier;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.demo.dao.CelebriteDao;
import com.example.demo.dao.DepartementDao;
import com.example.demo.dao.LieuDao;
import com.example.demo.dao.MonumentDao;
import com.example.demo.entities.Celebrite;
import com.example.demo.entities.Departement;
import com.example.demo.entities.Lieu;
import com.example.demo.entities.Monument;
import com.example.demo.entities.User;

import org.apache.lucene.*;
import org.apache.lucene.util.SloppyMath;

@Service
@Transactional
public class Metier implements IMetier{

// injection 	

@Autowired
private CelebriteDao celebritedao;
@Autowired
private MonumentDao monumentdao;
@Autowired
private DepartementDao departementdao;
@Autowired
private LieuDao lieudao;


// Enregistrer une celebrite
@Override
public Celebrite save(Celebrite c) {
	// TODO Auto-generated method stub
	return celebritedao.save(c);
	}

// Liste des celebrites
@Override
public List<Celebrite> findAllCelebrite() {
	// TODO Auto-generated method stub
	return celebritedao.findAll();
	}

//Enregistrer un  monument
@Override
public Monument save(Monument m) {
	// TODO Auto-generated method stub
	return monumentdao.save(m);
	}

//Liste des monuments
@Override
public List<Monument> findAllMonument() {
	// TODO Auto-generated method stub
	return monumentdao.findAll();
	}

//Suppression celebrite
@Override
public String deleteCelebrite(Integer numCelebrite) {
	// TODO Auto-generated method stub
	Celebrite c = celebritedao.getOne(numCelebrite);
	celebritedao.delete(c);
	return "Celebrité supprimée";
	}

//Supprimer un monument
@Override
public String deleteMonument(String codeM) {
	// TODO Auto-generated method stub
	Monument m = monumentdao.getOne(codeM);
	monumentdao.delete(m);
	return "Monument supprimé";
	}

//Calculer distance entre monuments
@SuppressWarnings("deprecation")
@Override
public double CalculDistanceEntreMonuments(String CodeMA, String CodeMB) {
		double latitudeA = monumentdao.getOne(CodeMA).getLatitude();
		double longitudeA = monumentdao.getOne(CodeMA).getLongitude();
		double latitudeB = monumentdao.getOne(CodeMB).getLatitude();
		double longitudeB = monumentdao.getOne(CodeMB).getLongitude();
		double distance = SloppyMath.haversinKilometers(latitudeA, longitudeA, latitudeB, longitudeB);
		return distance;
	}

//Trouver monuments selon leur nom	
@Override
public Monument findMonumentByNom(String nomM) {
	List<Monument> liste = monumentdao.findAll();
	for(Monument monument:liste) {
	if(monument.getNomM().equals(nomM) || monument.getCodeM().equals(nomM)  ) {
		return monument;
	}
}
			
		return null;
		
	}


//Enregistrer un departement
@Override
public Departement save(Departement d) {
	// TODO Auto-generated method stub
	return departementdao.save(d);
}

//Liste des departements
@Override
public List<Departement> findAllDepartement() {
	// TODO Auto-generated method stub
	return departementdao.findAll();
}

//Supprimer un departement
@Override
public String deletedepartement(String dep) {
	// TODO Auto-generated method stub
	Departement d = departementdao.getOne(dep);
	departementdao.delete(d);
	return "departement supprimé";
	}
	
//Enregistrer un  lieu
@Override
public Lieu save(Lieu l) {
	// TODO Auto-generated method stub
	return lieudao.save(l);
}

// Liste des lieux
@Override
public List<Lieu> findAllLieu() {
	// TODO Auto-generated method stub
	return lieudao.findAll();
}

//Supprimer un lieu
@Override
public String deletelieu(String codeInsee) {
	// TODO Auto-generated method stub
	Lieu l = lieudao.getOne(codeInsee);
	lieudao.delete(l);
	return "lieu supprimé";
}

//Associer celebrite à un monument
@Override
public void AddCelebriteToMonument(Integer numCelebrite, String CodeM) {
	Monument mo = monumentdao.getOne(CodeM);
	Celebrite c = celebritedao.getOne(numCelebrite);
	c.getCodeM().add(mo);
	mo.getCelebrites().add(c);
		
	}

//Liste des celebrites selon un monument
@Override
public Collection<Celebrite> GetCelebriteByMonument(String codeM) {
	Monument m = monumentdao.getMonument(codeM);
	return m.getCelebrites();
	}

//Liste des monuments selon un departement	
@Override
public Collection<Monument> GetMonumentByDepartement(String dep) {
		Departement d = departementdao.getDepartement(dep);
		Collection<Lieu> l = d.getLieux();
		Collection<Monument> res = new ArrayList<>();
		for(Lieu c:l)
			for(Monument m:c.getMonuments())
				res.add(m);			
		return res;

	}

//Liste des monuments selon une celebrite	
@Override
public Collection<Monument> GetMonumentByCelebrite(String nom) {
	Celebrite c = celebritedao.getCelebrite(nom);
	Collection<Monument> m = c.getCodeM();
	return m;
	
	}

	
	
	

	

	
	

	

}
