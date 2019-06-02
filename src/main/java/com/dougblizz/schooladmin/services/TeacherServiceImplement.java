package com.dougblizz.schooladmin.services;

import com.dougblizz.schooladmin.entities.Teacher;
import com.dougblizz.schooladmin.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("teacherService")
public class TeacherServiceImplement implements TeacherService{

    @Autowired
    @Qualifier("teacherRepository")
    private TeacherRepository teacherRepository;

    @Override
    public List<Teacher> allTeachers() {
        return teacherRepository.findAll();
    }

    @Override
    public void addSchool() {

    }
}
