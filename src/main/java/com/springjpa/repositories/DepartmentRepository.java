package com.springjpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springjpa.entities.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{
	
	//@Query("SELECT d FROM Department d LEFT JOIN FETCH d.entities WHERE d.id = :id")
	//Department findDepartmentWithEntities(@Param("id") Long id);
}
