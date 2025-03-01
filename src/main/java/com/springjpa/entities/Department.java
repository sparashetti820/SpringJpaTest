package com.springjpa.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Department {

	@Id
	@SequenceGenerator(name = "dept_id_generator", sequenceName = "dept_id_generator", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dept_id_generator")
	private Long id;

	private String departmentName;
	
	@OneToOne(mappedBy = "department")
	private HeadOfDepartment headOfDepartment;
	
	//not recommended
	//@OneToMany(cascade = CascadeType.ALL)
	//@JoinColumn(name = "teacher_id",referencedColumnName = "id")
	//private List<Teacher> teachers;

}
