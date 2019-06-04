package com.dougblizz.schooladmin.repositories;

import com.dougblizz.schooladmin.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("studentRepository")
public interface StudentRepository extends JpaRepository <Student, Long>  {
}
