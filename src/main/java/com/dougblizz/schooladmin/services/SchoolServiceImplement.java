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
}
