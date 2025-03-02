package com.springjpa.repositorytest;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.springjpa.entities.Department;
import com.springjpa.entities.Guardian;
import com.springjpa.entities.StudentEntity;
import com.springjpa.repositories.DepartmentRepository;
import com.springjpa.repositories.StudentRepository;

@SpringBootTest
public class StudentRepoTest {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Test
	public void saveAllStudents() {
		Optional<Department> department = departmentRepository.findById(3L);
		Department d = department.get();
		Guardian guardian = Guardian.builder().firstName("xyz").lastName("pqr").contactNumber("7787657876").build();
		List<StudentEntity> collect = IntStream.range(1, 10).mapToObj(i->{
			StudentEntity entity = StudentEntity.builder().firstName("abc"+i)
					.lastName("test").emailId("abc"+i+"@test.com").department(d)
					.guardian(guardian).mobileNumber("890668845"+i).build();
			return entity;
		}).collect(Collectors.toList());
		studentRepository.saveAll(collect);
	}
	
	@Test
	public void getAllData() {
		PageRequest of = PageRequest.of(0, 5);
		Page<StudentEntity> findByFirstNameContaining = studentRepository.findByFirstNameContaining("ab", of);
		findByFirstNameContaining.forEach(c->System.out.println(c));
	}

}
