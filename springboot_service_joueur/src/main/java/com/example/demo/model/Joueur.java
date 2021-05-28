package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="joueurs")
public class Joueur {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="nom")
    private String nom;
	
	@Column(name="prenom")
    private String prenom;
	
	@Column(name="matricule")
    private int matricule;
	
	@Column(name="age")
    private int age;
	
	@Column(name="sexe")
	private char sexe;
	
	@Column(name="taille")
    private float taille;
	
	@Column(name="poids")
    private float poids;
	
	@Column(name="nationalite")
    private String nationalite;
	
	@Column(name="categorie")
    private String categorie;
	
	@Column(name="poste_joueur")
    private String posteJoueur;
	
	@Column(name="numero_maillot")
    private int numeroMaillot;
    
    
    
    
	public Joueur() {
		super();
	}
	public Joueur(String nom, String prenom, int matricule, int age, char sexe, float taille, float poids,
			String nationalite, String categorie, String posteJoueur, int numeroMaillot) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.matricule = matricule;
		this.age = age;
		this.sexe = sexe;
		this.taille = taille;
		this.poids = poids;
		this.nationalite = nationalite;
		this.categorie = categorie;
		this.posteJoueur = posteJoueur;
		this.numeroMaillot = numeroMaillot;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public int getMatricule() {
		return matricule;
	}
	public void setMatricule(int matricule) {
		this.matricule = matricule;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public char getSexe() {
		return sexe;
	}
	public void setSexe(char sexe) {
		this.sexe = sexe;
	}
	public float getTaille() {
		return taille;
	}
	public void setTaille(float taille) {
		this.taille = taille;
	}
	public float getPoids() {
		return poids;
	}
	public void setPoids(float poids) {
		this.poids = poids;
	}
	public String getNationalite() {
		return nationalite;
	}
	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}
	public String getCategorie() {
		return categorie;
	}
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	public String getPosteJoueur() {
		return posteJoueur;
	}
	public void setPosteJoueur(String posteJoueur) {
		this.posteJoueur = posteJoueur;
	}
	public int getNumeroMaillot() {
		return numeroMaillot;
	}
	public void setNumeroMaillot(int numeroMaillot) {
		this.numeroMaillot = numeroMaillot;
	}
    
    

}
