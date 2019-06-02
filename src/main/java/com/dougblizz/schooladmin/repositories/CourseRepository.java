package com.dougblizz.schooladmin.repositories;

import com.dougblizz.schooladmin.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("courseRepository")
public interface CourseRepository extends JpaRepository<Course, Serializable> {
}
