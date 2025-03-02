package com.springjpa.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springjpa.entities.StudentEntity;


@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long>{
	
	Page<StudentEntity> findByFirstNameContaining(String firstName,Pageable pageable);

}
