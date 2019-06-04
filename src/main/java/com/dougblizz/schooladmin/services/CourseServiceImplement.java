package com.dougblizz.schooladmin.services;

import com.dougblizz.schooladmin.entities.Course;
import com.dougblizz.schooladmin.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("courseService")
public class CourseServiceImplement implements CourseService{

    @Autowired
    @Qualifier("courseRepository")
    private CourseRepository courseRepository;

    @Override
    public List<Course> allCourses() {
        return courseRepository.findAll();
    }
}
