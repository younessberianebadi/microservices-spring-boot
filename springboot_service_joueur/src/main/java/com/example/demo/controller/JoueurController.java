package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Joueur;
import com.example.demo.repository.JoueurRepository;

@RestController
@RequestMapping("/api/v1/")
public class JoueurController {
	
	
	@Autowired
	private JoueurRepository joueurRepository;
	
	
	// get players
	
	@GetMapping("joueurs")
	public List<Joueur> getAllJoueur(){
		return this.joueurRepository.findAll();
	}
	
	// get player by id
	@GetMapping("joueurs/{id}")
	public ResponseEntity<Joueur>  getJoueurById(@PathVariable(value="id") Long joueurId)
		throws ResourceNotFoundException{
		Joueur joueur=joueurRepository.findById(joueurId)
				.orElseThrow(()-> new ResourceNotFoundException("Joueur not found  for this id::" + joueurId ));
		return ResponseEntity.ok().body(joueur);
	
	}

	// save player
	@PostMapping("joueurs")
	public Joueur createJoueur(@RequestBody Joueur joueur) {
		return this.joueurRepository.save(joueur);
	}
	
	// update player
	@PutMapping("joueurs/{id}")
	public ResponseEntity<Joueur> updateJoueur(@PathVariable(value="id") Long joueurId, @Validated  @RequestBody Joueur joueurDetails) throws ResourceNotFoundException{
		Joueur joueur=joueurRepository.findById(joueurId)
				.orElseThrow(()-> new ResourceNotFoundException("Joueur not found for this id::"+joueurId)) ;
				
		joueur.setNom(joueurDetails.getNom());
		joueur.setPrenom(joueurDetails.getPrenom());
		joueur.setMatricule(joueurDetails.getMatricule());
		joueur.setAge(joueurDetails.getAge());
		joueur.setSexe(joueurDetails.getSexe());
		joueur.setTaille(joueurDetails.getTaille());
		joueur.setPoids(joueurDetails.getPoids());
		joueur.setNationalite(joueurDetails.getNationalite());
		joueur.setCategorie(joueurDetails.getCategorie());
		joueur.setPosteJoueur(joueurDetails.getPosteJoueur());
		joueur.setNumeroMaillot(joueurDetails.getNumeroMaillot());
		
		return ResponseEntity.ok(this.joueurRepository.save(joueur));
		
	}
	
	//delete player
	@DeleteMapping("joueurs/{id}")
	public Map<String, Boolean> deleteJoueur(@PathVariable(value="id") Long joueurId ) throws ResourceNotFoundException{
		Joueur joueur=joueurRepository.findById(joueurId)
				.orElseThrow(()-> new ResourceNotFoundException("Joueur not found for this id::"+ joueurId));
				
		this.joueurRepository.delete(joueur);
		
		Map<String, Boolean> response= new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		
		return response;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
