package com.dougblizz.schooladmin.entities;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "student")
public class Student {

    private long id;
    private String name;
    private Date birth;
    private School school;

    public Student() {
    }

    public Student(String name, Date birth, School school) {
        this.name = name;
        this.birth = birth;
        this.school = school;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", unique = true, nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name="name", nullable = false, length = 145)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name="birth", nullable = false)
    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }
}
