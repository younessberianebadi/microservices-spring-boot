package io.digiwise.uiservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

import static io.digiwise.uiservice.Player.category.u10;
import static io.digiwise.uiservice.Player.sexe.male;

@SpringBootApplication
public class UiServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(UiServiceApplication.class, args);
	}
	/*
	@Component
	public class DatabaseLoader implements CommandLineRunner{

		private final PlayerRepository repository;

		@Autowired
		public DatabaseLoader(PlayerRepository repository){
			this.repository = repository;
		}

		@Override
		public void run(String... args) throws Exception {
			this.repository.save(new Player("Hassan", "Amir", Player.nationality.moroccan, LocalDate.of(2011, 02, 01), male, u10, 60, 1));

		}
	} */



}
