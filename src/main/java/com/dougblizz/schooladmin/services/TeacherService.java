package com.dougblizz.schooladmin.services;

import com.dougblizz.schooladmin.entities.School;
import com.dougblizz.schooladmin.entities.Teacher;

import java.util.List;

public interface TeacherService {

    public abstract List<Teacher> allTeachers();

    public abstract Teacher findTeacherById(Long id);

    public abstract Teacher addTeacher(Teacher teacher);

    public abstract void deleteTeacher(Long id);

}
