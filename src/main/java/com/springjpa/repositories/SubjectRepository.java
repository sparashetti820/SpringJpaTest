package com.springjpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springjpa.entities.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long>{

}
