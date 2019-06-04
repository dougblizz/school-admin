package com.dougblizz.schooladmin.repositories;

import com.dougblizz.schooladmin.entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("teacherRepository")
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

}
