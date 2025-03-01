package com.springjpa.repositorytest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springjpa.entities.College;
import com.springjpa.repositories.CollegeRepository;

@SpringBootTest
public class CollegeRepoTest {

	@Autowired
	private CollegeRepository collegeRepository;

	@Test
	public void createCollege() {

		College college = College.builder().collegeName("ABC Institute of Technology,Bagalore").address("Bengaluru")
				.emailId("abcit@test.com").collegeContact("8978657654").foundedOn(LocalDate.of(2000, 01, 01))
				.universitySerialNumber("2AB")
				.build();
		collegeRepository.save(college);

	}
	
	@Test
	public void getAllColleges() {
		List<College> findAll = collegeRepository.findAll();
		findAll.forEach(System.out::println);
	}
	
	@Test
	public void getCollegebyContact() {
		Optional<College> college = collegeRepository.findByCollegeContact("8978657654");
		college.ifPresent(c->System.out.println(c));
	}

}
