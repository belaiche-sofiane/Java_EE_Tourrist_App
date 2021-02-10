package com.example.demo.web;

import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.dao.CelebriteDao;
import com.example.demo.dao.MonumentDao;
import com.example.demo.dao.UserRepository;
import com.example.demo.entities.Celebrite;
import com.example.demo.entities.Departement;
import com.example.demo.entities.User;
import com.example.demo.metier.IMetier;
@Controller
public class Celebriteweb {
@Autowired
private IMetier metier;
@Autowired
private CelebriteDao celebritedao;



// Liste des celebrites
@Secured(value = { "ROLE_ADMIN", "ROLE_USER"})
@RequestMapping(value ="/celebrites", method = RequestMethod.GET)
public String ListeCelebrites(Model model) {

        List<Celebrite> celebrites= metier.findAllCelebrite();
        model.addAttribute("celebrites", celebrites);
        return "celebrites";
}

//Ajout celebrité
@Secured(value = { "ROLE_ADMIN"})
@RequestMapping(value = "/ajoutCelebrite", method = RequestMethod.GET)
public String formcelebrite(Model model) {
  try {	
	model.addAttribute("Celebrite", new Celebrite());
	return "ajoutCelebrite";
  }
 catch(AccessDeniedException e) {
   
    return "success";
}
 }	

//Enregistrement celebrite
@Secured(value = { "ROLE_ADMIN"})
@RequestMapping(value = "/SaveCelebrite", method = RequestMethod.POST)
public String savecelebrite(Celebrite c) {
	metier.save(c);
	return "success";
	}
	
// Formulaire de connexion	
@GetMapping(value = "/login")
public String login() {
	return "connexion";//
}	

	
//Supprimer celebrite	
@Secured(value = { "ROLE_ADMIN"})
@RequestMapping(value="/deleteC")
public String deleteC(Integer numCelebrite) {
	metier.deleteCelebrite(numCelebrite);
	return "success";
	}

//Retourner le formulaire de Modification de celebrite
@Secured(value = { "ROLE_ADMIN" })
@RequestMapping(value = "/ModifierC")
public String ModifierC(Model model, Integer codeC) {
	Celebrite c  = celebritedao.getOne(codeC);
	model.addAttribute("celebrite", c);
		return "EditCelebrite";
	}

//Modifier celebrite
@Secured(value = { "ROLE_ADMIN" })
@RequestMapping(value = "/updateCelebrite", method = RequestMethod.POST)
public String update(Celebrite c) {
	celebritedao.save(c);
	return "success";
	}
	
//Liste des celebrites selon un monument
@Secured(value = { "ROLE_ADMIN", "ROLE_USER"})
@RequestMapping(value = "/ListcelebritebyMon")
public String pagelistcelebAssocierM() {
	return "ListcelebritebyMon";
	}

//Liste des celebrites selon un monument
@Secured(value = { "ROLE_ADMIN", "ROLE_USER"})
@RequestMapping(value = "/listCeleb")
public String listcelebAssocierM(Model model, String codeM) {
	try {
		Collection<Celebrite> listcele = metier.GetCelebriteByMonument(codeM);
		model.addAttribute("listc", listcele);

		} catch (Exception e) {
			model.addAttribute("exception", e);
		}
		return "ListcelebritebyMon";
	}
		

   
	
}
