package com.dougblizz.schooladmin.services;

import com.dougblizz.schooladmin.entities.Teacher;

import java.util.List;

public interface TeacherService {
    public abstract List<Teacher> allTeachers();
    public abstract void addSchool();
}
