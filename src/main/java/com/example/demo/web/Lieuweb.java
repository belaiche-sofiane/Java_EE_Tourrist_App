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
import com.example.demo.dao.LieuDao;
import com.example.demo.entities.Celebrite;
import com.example.demo.entities.Departement;
import com.example.demo.entities.Lieu;
import com.example.demo.entities.Monument;
import com.example.demo.metier.IMetier;

@Controller
public class Lieuweb {
	@Autowired
	private IMetier metier;
	@Autowired
	private DepartementDao departementdao;
	@Autowired
	private LieuDao lieudao;
	
	
// Liste des lieux	
@Secured(value = { "ROLE_ADMIN", "ROLE_USER"})
@RequestMapping(value ="/lieux", method = RequestMethod.GET)
public String ListeLieux(Model model) {
	List<Lieu> lieux = metier.findAllLieu();
	model.addAttribute("lieux", lieux);
	return "lieux";
	}
	
//Ajouter un lieu
@Secured(value = { "ROLE_ADMIN"})
@RequestMapping(value = "/ajoutLieu", method = RequestMethod.GET)
public String formlieu(Model model) {
	try {	
		model.addAttribute("lieu", new Lieu());
		return "ajoutLieu";
	  }
	 catch(AccessDeniedException e) {
	   
	    return "success";
	}	
	
}
//Enregistrement un lieu
@Secured(value = { "ROLE_ADMIN"})
@RequestMapping(value = "/SaveLieu", method = RequestMethod.POST)
public String savelieu(Lieu l) {
List<Departement> liste = departementdao.findAll();
	for(Departement d : liste) {
		if(l.getDep() == d) {
				metier.save(l);
				return "success";
			}
			
			else {
				return "error";
			}
		
		}
			
			return "error";
		}
	
//Supprimer un lieu
@Secured(value = { "ROLE_ADMIN"})
@RequestMapping(value="/deleteL")
public String deleteL(String codeInsee) {
	 metier.deletelieu(codeInsee);
	return "success";
	}
	
	
// Modifier un lieu	
@Secured(value = { "ROLE_ADMIN" })
@RequestMapping(value = "/ModifierL")
public String ModifierM(Model model, String codeL) {
	Lieu l  = lieudao.getOne(codeL);
	model.addAttribute("lieu", l);
	return "EditLieu";
	}

//Modification lieu
@Secured(value = { "ROLE_ADMIN" })
@RequestMapping(value = "/updateLieu", method = RequestMethod.POST)
public String update(Lieu l) {
	lieudao.save(l);// si on lui donne un monumet qui existe déja elle fait update
	return "success";
	}
	
	
	
	
	
	
	
	
}
