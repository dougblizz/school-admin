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
    public Teacher findTeacherById(Long id) {
        return teacherRepository.findById(id).get();
    }

    @Override
    public Teacher addTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public List<Teacher> allTeachers() {
        return teacherRepository.findAll();
    }

    @Override
    public void deleteTeacher(Long id) {
        Teacher teacher = findTeacherById(id);
        if (teacher != null) {
            teacherRepository.delete(teacher);
        }
    }
}
