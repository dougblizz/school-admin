package com.dougblizz.schooladmin.services;

import com.dougblizz.schooladmin.entities.School;

import java.util.List;

public interface SchoolService {
    public abstract List<School> allSchools();

    public abstract School addSchool(School school);

    public abstract School findSchoolById(Long id);

    public abstract void deleteSchool(Long id);
}
