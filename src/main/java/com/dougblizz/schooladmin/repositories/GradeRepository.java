package com.dougblizz.schooladmin.repositories;

import com.dougblizz.schooladmin.entities.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("gradeRepository")
public interface GradeRepository extends JpaRepository<Grade, Long> {
}
