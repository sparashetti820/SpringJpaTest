package com.springjpa.repositorytest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springjpa.entities.College;
import com.springjpa.entities.Department;
import com.springjpa.repositories.CollegeRepository;
import com.springjpa.repositories.DepartmentRepository;

@SpringBootTest
public class DepartmentRepoTest {
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired
	private CollegeRepository repository;
	
	
	@Test
	public void createDepartments() {
		List<Department> departments = new ArrayList<>();
		Optional<College> college = repository.findById(1);
		College c = college.get();
		Department department1 = Department.builder().college(c).departmentName("CSE").build();
		Department department2 = Department.builder().college(c).departmentName("ECE").build();
		departments.add(department1);
		departments.add(department2);
		departmentRepository.saveAll(departments);
	}
	
	@Test
	public void getAllDepartments() {
		List<Department> departments = departmentRepository.findAll();
		departments.forEach(System.out::println);
	}

}
