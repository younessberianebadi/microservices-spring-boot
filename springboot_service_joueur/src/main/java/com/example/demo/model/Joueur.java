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
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	enum position{
		Attacker,
		Defender,
		Mildfielder,
		Goalkeeper
	}

	enum sexe{
		Male,
		Female
	}

	enum categorie{
		U6,
		U8,
		U10,
		U12,
		U14,
		U16
	}

	enum nationality{
		Moroccan,
		Foreigner
	}

	@Column(name="nom")
    private String nom;
	
	@Column(name="prenom")
    private String prenom;
	
	@Column(name="matricule")
    private int matricule;
	
	@Column(name="age")
    private int age;
	
	@Column(name="sexe")
	private sexe sexe;
	
	@Column(name="taille")
    private float taille;
	
	@Column(name="poids")
    private float poids;
	
	@Column(name="nationalite")
    private nationality nationalite;
	
	@Column(name="categorie")
    private categorie categorie;
	
	@Column(name="poste_joueur")
    private position posteJoueur;
	
	@Column(name="numero_maillot")
    private int numeroMaillot;
    
    
    
    
	public Joueur() {
		super();
	}
	public Joueur(String nom, String prenom, int matricule, int age, sexe sexe, float taille, float poids,
			nationality nationalite, categorie categorie, position posteJoueur, int numeroMaillot) {
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
	public sexe getSexe() {
		return sexe;
	}
	public void setSexe(sexe sexe) {
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
	public nationality getNationalite() {
		return nationalite;
	}
	public void setNationalite(nationality nationalite) {
		this.nationalite = nationalite;
	}
	public categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(categorie categorie) {
		this.categorie = categorie;
	}
	public position getPosteJoueur() {
		return posteJoueur;
	}
	public void setPosteJoueur(position posteJoueur) {
		this.posteJoueur = posteJoueur;
	}
	public int getNumeroMaillot() {
		return numeroMaillot;
	}
	public void setNumeroMaillot(int numeroMaillot) {
		this.numeroMaillot = numeroMaillot;
	}
    
    

}
