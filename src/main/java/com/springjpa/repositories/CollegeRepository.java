package com.springjpa.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springjpa.entities.College;

@Repository
public interface CollegeRepository extends JpaRepository<College, Integer>{
	
	Optional<College> findByCollegeContact(String collegeContact);

}
