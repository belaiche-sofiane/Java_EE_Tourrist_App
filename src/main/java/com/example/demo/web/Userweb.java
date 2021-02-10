package com.example.demo.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.UserRepository;
import com.example.demo.entities.User;
import com.example.demo.metier.Metier;
import com.example.demo.metier.MyUserDetailsService;
@Controller
public class Userweb {
	@Autowired
	private MyUserDetailsService metier;

//Inscription d'un nouveau utilisateur
@GetMapping("/inscription")
public String inscription(Model model) {
		User u = new User();
		model.addAttribute("user", new User());
		return "inscription";
	}


//Enregistrement d'un nouveau utilisateur
@RequestMapping(value = "/SaveUser", method = RequestMethod.POST)
public String saveUser(User u) {
	metier.saveUser(u);
	return "connexion";
		}

//Déconnexion de l'application
@GetMapping("/logout")
public String fetchSignoutSite(HttpServletRequest request, HttpServletResponse response) {        
	 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	 if (auth != null) {
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	        }
	          
	        return "redirect:/login?logout";
	    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
