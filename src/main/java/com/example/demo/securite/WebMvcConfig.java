package com.example.demo.securite;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebMvcConfig extends WebMvcConfigurerAdapter {
	@Override
	public void addViewControllers(ViewControllerRegistry registry){
		//correspondence entre les urls et les vues
		//soit on le fait commeça soit on peut creer une methode dans 
		//le controlleur qui vas me retournera page d'authentification
	
       // registry.addViewController("/logout").setViewName("connexion");//reviens ici

	       
		
	}
}
