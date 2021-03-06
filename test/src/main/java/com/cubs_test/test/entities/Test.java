package com.cubs_test.test.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "test")

public class Test {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "date")
    private LocalDate date;

    @Column(name = "player_name")
    private String player_name;

    @Column(name = "type")
    private String test_type;

    @Column(name = "test_name")
    private String test_name;

    @Column(name = "result")
    private int test_result;

    @Column(name = "comment")
    private String comment;

    public Test(){
        super();
    }

    public Test(LocalDate date,String player_name, String test_type, String test_name, int test_result, String comment) {
        super();
        this.date = date;
        this.player_name = player_name;
        this.test_type = test_type;
        this.test_name = test_name;
        this.test_result = test_result;
        this.comment = comment;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlayer_name() {
        return player_name;
    }

    public void setPlayer_name(String player_name) {
        this.player_name = player_name;
    }

    public String getTest_type() {
        return test_type;
    }

    public void setTest_type(String test_type) {
        this.test_type = test_type;
    }

    public String getTest_name() {
        return test_name;
    }

    public void setTest_name(String test_name) {
        this.test_name = test_name;
    }

    public int getTest_result() {
        return test_result;
    }

    public void setTest_result(int test_result) {
        this.test_result = test_result;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
