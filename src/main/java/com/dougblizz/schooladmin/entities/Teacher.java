package com.dougblizz.schooladmin.entities;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="teacher")
public class Teacher {
    private Long id;
    private String name;
    private Date birth;
    private boolean active;
    private School school;
    private Course course;

    public Teacher() {
    }

    public Teacher(String name, Date birth, boolean active, School school, Course course) {
        this.name = name;
        this.birth = birth;
        this.active = active;
        this.school = school;
        this.course = course;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", unique = true, nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name="name",nullable = false, length = 145)
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

    @Column(name="active", nullable = false)
    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birth=" + birth +
                ", active=" + active +
                ", school=" + school +
                ", course=" + course +
                '}';
    }
}
