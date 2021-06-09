package com.example.demo;

import com.example.demo.model.Joueur;
import com.example.demo.repository.JoueurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class SpringbootServiceJoueurApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootServiceJoueurApplication.class, args);
	}

	/*
	@Component
	public class DatabaseLoader implements CommandLineRunner {
		private final JoueurRepository repository;
		@Autowired
		public DatabaseLoader(JoueurRepository repository){
			this.repository = repository;
		}
		@Override
		public void run(String... args) throws Exception {
			this.repository.save(new Joueur("Ali", "Elghaiki", 3, 10, 'M', 1.3f, 50,
			"Marocain", "U10", "Attaquant", 9));
			this.repository.save(new Joueur("Amina", "Alaoui", 3, 10, 'F', 1.3f, 50,
					"Marocaine", "U10", "Attaquant", 9));
		}
	}

	 */

}
