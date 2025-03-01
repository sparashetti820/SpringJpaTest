package com.springjpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springjpa.entities.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long>{

}
