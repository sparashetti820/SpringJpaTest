package com.springjpa.repositorytest;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springjpa.entities.Department;
import com.springjpa.entities.StudentEntity;
import com.springjpa.entities.Subject;
import com.springjpa.repositories.StudentRepository;

@SpringBootTest
public class StudentRepositoryTest {

	@Autowired
	private StudentRepository studentRepository;

	@Test
	public void saveStudent() {
		Department department = Department.builder().departmentName("Computer Science").build();
		StudentEntity studentEntity = StudentEntity.builder().firstName("Shiva").lastName("P")
				.emailId("shiva123@gmail.com").mobileNumber("9731224087")
				.department(department)
				.build();
		studentRepository.save(studentEntity);

	}
	
	@Test
	public void printAllSavedData() {
		List<StudentEntity> findAll = studentRepository.findAll();
		System.out.println(findAll);
	}
	
	@Test
	public void saveSubjectAndStudent() {
		Subject subject = Subject.builder().subjectName("DSA").rating(10).build();
		StudentEntity studentEntity = StudentEntity.builder().firstName("Shiva").lastName("P")
				.emailId("shiva123@gmail.com").mobileNumber("9731224087")
				.subjects(Arrays.asList(new Subject[] {subject}))
				.build();
		studentRepository.save(studentEntity);
		
	}

}
