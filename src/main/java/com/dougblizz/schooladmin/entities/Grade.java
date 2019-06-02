package com.dougblizz.schooladmin.entities;

import javax.persistence.*;

@Entity
@Table(name="grade")
public class Grade {
    private long id;
    private String name;

    public Grade() {
    }

    public Grade(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", unique = true,nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name="name",nullable = false,length = 145)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
