package com.dougblizz.schooladmin.repositories;

import com.dougblizz.schooladmin.entities.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("schoolRepository")
public interface SchoolRepository extends JpaRepository<School, Serializable> {
}
