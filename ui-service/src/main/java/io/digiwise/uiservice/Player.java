package io.digiwise.uiservice;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Player {

    enum sexe{
        male,
        female,
        other
    }

    enum nationality{
        moroccan,
        foreigner
    }

    enum category{
        u8,
        u10,
        u12,
        u14,
        u16
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "fname")
    private String fname;

    @Column(name = "lname")
    private String lname;

    @Column(name = "nationality")
    private nationality nationality;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "birthday")
    private LocalDate birthday;

    @Column(name = "sexe")
    private sexe sexe;

    @Column(name = "category")
    private category category;

    @Column(name = "weight")
    private float weight;

    @Column(name = "height")
    private float height;

    public Player(){


    }


    public Player(String fname, String lname, Player.nationality nationality, LocalDate birthday, Player.sexe sexe, Player.category category, float weight, float height) {
        super();
        this.fname = fname;
        this.lname = lname;
        this.nationality = nationality;
        this.birthday = birthday;
        this.sexe = sexe;
        this.category = category;
        this.weight = weight;
        this.height = height;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public nationality getNationality() {
        return nationality;
    }

    public void setNationality(nationality nationality) {
        this.nationality = nationality;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Player.sexe getSexe() {
        return sexe;
    }

    public void setSexe(Player.sexe sexe) {
        this.sexe = sexe;
    }

    public Player.category getCategory() {
        return category;
    }

    public void setCategory(Player.category category) {
        this.category = category;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }
}
