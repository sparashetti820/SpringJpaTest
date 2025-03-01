package com.springjpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springjpa.entities.HeadOfDepartment;

@Repository
public interface HeadOfDepartmentRepository extends JpaRepository<HeadOfDepartment, Integer> {

}
