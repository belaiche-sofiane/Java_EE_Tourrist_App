package com.example.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.dao.DepartementDao;
import com.example.demo.entities.Departement;
import com.example.demo.entities.Lieu;
import com.example.demo.metier.IMetier;

@Controller
public class Departementweb {
	@Autowired
	private IMetier metier;
	@Autowired
	private DepartementDao departementdao;;
	
// Liste des departements
@Secured(value = { "ROLE_ADMIN", "ROLE_USER"})
@RequestMapping(value ="/departements", method = RequestMethod.GET)
public String ListeDepartements(Model model) {
	List<Departement> departements = metier.findAllDepartement();
	model.addAttribute("departements", departements);
	return "departements";
	}
	
//Ajout departement
@Secured(value = { "ROLE_ADMIN"})
@RequestMapping(value = "/ajoutDepartement", method = RequestMethod.GET)
public String formdepartement(Model model) {
	try {	
		model.addAttribute("departement", new Departement());
		return "ajoutDepartement";
	  }
	 catch(AccessDeniedException e) {
	   
	    return "success";
	}	
	
	}

//Enregistrement departement
@Secured(value = { "ROLE_ADMIN"})
@RequestMapping(value = "/SaveDepartement", method = RequestMethod.POST)
public String savedepartement(Departement d) {
	metier.save(d);
	return "success";
		}
	
//Supprimer un departement
@Secured(value = { "ROLE_ADMIN"})
@RequestMapping(value="/deleteD")
public String deleteD(String dep) {
	metier.deletedepartement(dep);
	return "success";
	}
	
// Modifier un departement	
@Secured(value = { "ROLE_ADMIN" })
@RequestMapping(value = "/ModifierD")
public String ModifierD(Model model, String codeD) {
	Departement d  = departementdao.getOne(codeD);
	model.addAttribute("departement", d);
	return "EditDepartement";
	}

// Modifier un departement
@Secured(value = { "ROLE_ADMIN" })
@RequestMapping(value = "/updateDepartement", method = RequestMethod.POST)
public String update(Departement d) {
	departementdao.save(d);
	return "success";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
