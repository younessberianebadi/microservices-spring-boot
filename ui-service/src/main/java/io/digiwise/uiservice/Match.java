package io.digiwise.uiservice;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;


@Entity
public class Match {


    enum type{
        friendly,
        league,
        cup
    }

    enum result {
        won,
        lost,
        drawn,
        notplayedyet
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "date")
    private LocalDate date;

    @Column(name = "time")
    private LocalTime time;

    @Column(name = "category")
    private Player.category category;

    @Column(name = "adversary")
    private String adversary;

    @Column(name = "type")
    private type type;

    @Column(name = "result")
    private result result;

    @Column(name = "score")
    private String score;

    public Match() {
        this.score = "-";
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public Player.category getCategory() {
        return category;
    }

    public void setCategory(Player.category category) {
        this.category = category;
    }

    public String getAdversary() {
        return adversary;
    }

    public void setAdversary(String adversary) {
        this.adversary = adversary;
    }

    public Match.type getType() {
        return type;
    }

    public void setType(Match.type type) {
        this.type = type;
    }

    public Match.result getResult() {
        return result;
    }

    public void setResult(Match.result result) {
        this.result = result;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public Match(LocalDate date, LocalTime time, Player.category category, String adversary, Match.type type, Match.result result, String score) {
        super();
        this.id = id;
        this.date = date;
        this.time = time;
        this.category = category;
        this.adversary = adversary;
        this.type = type;
        this.result = result;
        this.score = score;
    }
}
