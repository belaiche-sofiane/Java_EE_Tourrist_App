package com.example.demo.web;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.dao.LieuDao;
import com.example.demo.dao.MonumentDao;
import com.example.demo.entities.Lieu;
import com.example.demo.entities.Monument;
import com.example.demo.metier.IMetier;
@Controller
public class Monumentweb {
	@Autowired
	private IMetier metier;
	
	@Autowired
	private MonumentDao monumentdao;
	
	@Autowired
	private LieuDao lieudao;
	
//Liste des monuments	
@Secured(value = { "ROLE_ADMIN", "ROLE_USER"})
@RequestMapping(value ="/monuments", method = RequestMethod.GET)
public String ListeMonuments(Model model) {
	List<Monument> monuments= metier.findAllMonument();
	model.addAttribute("monuments", monuments);
	return "monuments";
	}

//Ajouter un monument
@Secured(value = {"ROLE_ADMIN"})
@RequestMapping(value = "/ajoutMonument", method = RequestMethod.GET)
public String formmonument(Model model) {
	model.addAttribute("Monument", new Monument());
	return "ajoutMonument";
}
	    
// Enregistrement monument
@Secured(value = { "ROLE_ADMIN"})
@RequestMapping(value = "/SaveMonument", method = RequestMethod.POST)
public String savemonument(Monument m) {
	  List<Lieu> liste = lieudao.findAll();
	  for(Lieu l : liste) {
	    if(m.getCodeLieu()==l) {
	    	metier.save(m);
	    		return "success";
	    		 }
	    		
	    	 }
			
			return "error";
	}	
	
//Supprimer un monument		
@Secured(value = { "ROLE_ADMIN"})
@RequestMapping(value="/deleteM")
public String deleteM(String codeM) {
	metier.deleteMonument(codeM);
	return "success";
}
	
//formulaire de calcul de distance
@Secured(value = { "ROLE_ADMIN","ROLE_USER"})
@RequestMapping(value = "/distance") //
public String dist() {
	return "distance";//
	}

//Calcul distance
@Secured(value = { "ROLE_ADMIN","ROLE_USER"})
@RequestMapping(value = "/calculeDistance")
public String calculeDistance(Model model, String codeMA, String codeMB) {
		Monument mA = monumentdao.getOne(codeMA);
		Monument mB = monumentdao.getOne(codeMB);
		double r= metier.CalculDistanceEntreMonuments(codeMA,codeMB);
		model.addAttribute("result", r);
		return "distance";
	}



//formulaire de recherche
@Secured(value = { "ROLE_ADMIN", "ROLE_USER"})
@RequestMapping(value = "/recherche") //
public String recherche() {
		return "search";//
}
		
//Recherche monuments
@Secured(value = { "ROLE_ADMIN","ROLE_USER"})
@RequestMapping(value = "/recherchemonument")
public String search(Model model,String nomM) {
	Monument m = monumentdao.getOne(nomM);
	Monument ls= metier.findMonumentByNom(nomM);
	System.out.println("ici la liste des monuments" + ls);
	model.addAttribute("recherche",ls);
	return "search";
}
	
//Modifier un monument
@Secured(value = { "ROLE_ADMIN" })
@RequestMapping(value = "/ModifierM")
public String ModifierM(Model model, String codeM) {
	Monument m = monumentdao.getOne(codeM);
	model.addAttribute("monument", m);
	return "EditMonument";
}

//Modification monument		
@Secured(value = { "ROLE_ADMIN" })
@RequestMapping(value = "/updateMonument", method = RequestMethod.POST)
public String update(Monument m) {
	monumentdao.save(m);
	return "success";
}
	
//associer une celebrite à un monument (formulaire d'association)
@Secured(value = {"ROLE_ADMIN"})
@RequestMapping(value = "/Associer")
public String formAsso() {
	return "AssossierCelebToMon";
}
//associer une celebrite à un monument
@Secured(value = { "ROLE_ADMIN"})
@RequestMapping(value = "/AssocierM")
public String AddCelebriteToMonumen(Integer numCelebrite, String CodeM) {
	metier.AddCelebriteToMonument(numCelebrite, CodeM);
	return "success";
}	
	
//Liste des monuments selon un departement
@Secured(value = { "ROLE_ADMIN", "ROLE_USER" })
@RequestMapping(value = "/listMonumentbydep")
public String listemon() {
	return "ListMonumentByDep";
}

// afficher les monuments d'un departement
@Secured(value = { "ROLE_ADMIN", "ROLE_USER" })
@RequestMapping(value = "/listMonbydep")
public String listmon(Model model, String dep) {
	try {
		Collection<Monument> listmon = metier.GetMonumentByDepartement(dep);
		model.addAttribute("list", listmon);

}   catch (Exception e) {
			model.addAttribute("exception", e);
			}
	return "ListMonumentByDep";
	   }
	
//Liste des monuments selon une celebrite (recherche)
@Secured(value = { "ROLE_ADMIN", "ROLE_USER" })
@RequestMapping(value = "/listMonumentbyceleb")
public String listemonbyceleb() {
	return "ListmonumentByCeleb";
}
	
		
//Liste des monuments selon une celebrite
@Secured(value = { "ROLE_ADMIN", "ROLE_USER" })
@RequestMapping(value = "/listMonbyceleb")
public String listmonbyceleb(Model model, String nom) {
	try {
		Collection<Monument> liste = metier.GetMonumentByCelebrite(nom);
		model.addAttribute("list", liste);

}   catch (Exception e) {
		model.addAttribute("exception", e);
			}
	return "ListmonumentByCeleb";
	   }	
	
	
}
