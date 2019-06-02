package com.dougblizz.schooladmin.entities;

import javax.persistence.*;

@Entity
@Table(name="course")
public class Course {
    private long id;
    private String name;

    public Course() {
    }

    public Course(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id",unique = true,nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name="name",nullable = false, length = 145)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
