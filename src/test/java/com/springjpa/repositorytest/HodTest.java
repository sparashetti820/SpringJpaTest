package com.springjpa.repositorytest;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springjpa.entities.Department;
import com.springjpa.entities.HeadOfDepartment;
import com.springjpa.repositories.DepartmentRepository;
import com.springjpa.repositories.HeadOfDepartmentRepository;

@SpringBootTest
public class HodTest {

	@Autowired
	private HeadOfDepartmentRepository departmentRepository;

	@Autowired
	private DepartmentRepository repository;

	@Test
	public void saveHOD() {
		Optional<Department> findById = repository.findById(1L);
		HeadOfDepartment department = HeadOfDepartment.builder().firstName("Test").lastName("sdsds")
				.emailId("hod@gamil.com").contactNumber("67678756565")
				.qualification("PhD")
				.department(findById.get()).build();
		departmentRepository.save(department);
	}

	@Test
	public void getAllData() {
		List<HeadOfDepartment> findAll = departmentRepository.findAll();
		System.out.println(findAll);
	}
}
