package com.springjpa.repositorytest;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springjpa.entities.Department;
import com.springjpa.repositories.DepartmentRepository;

@SpringBootTest
public class DepartmentRepositoryTest {

	@Autowired
	private DepartmentRepository departmentRepositoryTest;
	
	@Test
	public void getAllDepartment() {
		List<Department> findAll = departmentRepositoryTest.findAll();
		System.out.println(findAll);
	}
	
//	@Test
//	public void getStudentsByDepartment() {
//		Department findAll = departmentRepositoryTest.findDepartmentWithEntities(1L);
//		System.out.println(findAll);
//	}
	
}
