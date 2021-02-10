package com.example.demo;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.demo.dao.CelebriteDao;
import com.example.demo.dao.DepartementDao;
import com.example.demo.dao.LieuDao;
import com.example.demo.dao.MonumentDao;
import com.example.demo.entities.Celebrite;
import com.example.demo.entities.Departement;
import com.example.demo.entities.Lieu;
import com.example.demo.entities.Monument;
import com.example.demo.metier.IMetier;
import com.example.demo.metier.Metier;






@SpringBootApplication
public class ProjetHmin3272Application implements CommandLineRunner {
@Autowired
private LieuDao lieu;
@Autowired
private DepartementDao departement;
@Autowired
private CelebriteDao celebrite;
@Autowired
private MonumentDao monument;
@Autowired
private IMetier metier;
	public static void main(String[] args) {
		SpringApplication.run(ProjetHmin3272Application.class, args);
		
		    }

	@Override
	public void run(String... args) throws Exception {
		
		
   /* Departement d1 = departement.save(new Departement("34","dep","montpellier","34"));
	Lieu l1 = lieu.save(new Lieu("hhgf","montpellier",3.61,6.32,d1));
	
	Monument m1 = monument.save(new Monument("xxma", "placeCo", "tassa", "sta", 9.0, 1.0, l1));
	Celebrite c1 = celebrite.save(new Celebrite(2, "benA", "tass", "alger", "rec"));*/

	}

	
	
		
}
