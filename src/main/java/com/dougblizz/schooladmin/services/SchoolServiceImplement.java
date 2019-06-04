package com.dougblizz.schooladmin.services;

import com.dougblizz.schooladmin.entities.School;
import com.dougblizz.schooladmin.repositories.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("schoolService")
public class SchoolServiceImplement implements SchoolService {

    @Autowired
    @Qualifier("schoolRepository")
    private SchoolRepository schoolRepository;

    @Override
    public List<School> allSchools() {
        return schoolRepository.findAll();
    }

    @Override
    public School addSchool(School school) {
        School auxSchool = schoolRepository.save(school);
        return auxSchool;
    }

    @Override
    public School findContactById(Long id) {
        return schoolRepository.findById(id).get();
    }

    @Override
    public void deleteSchool(Long id) {
        School school = findContactById(id);
        if (school != null) {
            schoolRepository.delete(school);
        }
    }
}
