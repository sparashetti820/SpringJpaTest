package com.springjpa.repositorytest;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.springjpa.entities.Department;
import com.springjpa.entities.HeadOfDepartment;
import com.springjpa.repositories.DepartmentRepository;
import com.springjpa.repositories.HeadOfDepartmentRepository;

@SpringBootTest
public class HodRepoTest {

	@Autowired
	private HeadOfDepartmentRepository headOfDepartmentRepository;

	@Autowired
	private DepartmentRepository departmentRepository;

	@Test
	public void addHodDetails() {
		List<Department> departments = departmentRepository.findAll();
		List<HeadOfDepartment> collect = departments.stream().map(dept -> {
			HeadOfDepartment headOfDepartment = HeadOfDepartment.builder().department(dept).contactNumber("9089877662")
					.emailId(dept.getDepartmentName() + "hod@test.com").firstName(dept.getDepartmentName()+"_hod").lastName("sds")
					.qualification("Phd").build();
			return headOfDepartment;
		}).collect(Collectors.toList());
		headOfDepartmentRepository.saveAll(collect);

	}

}
