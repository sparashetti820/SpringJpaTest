package com.springjpa.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(uniqueConstraints = @UniqueConstraint(name="emailId_unique",columnNames = {"emailId","mobileNumber"}))
public class StudentEntity {

	@Id
	@SequenceGenerator(name = "student_id_generator", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_id_generator")
	private Long id;

	private String firstName;

	private String lastName;

	private String emailId;

	private String mobileNumber;
	
	private String usn;
	
	@Embedded
	private Guardian guardian;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "dept_id", referencedColumnName = "id",nullable = false)
	private Department department;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "student_sub_map", joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"), 
	inverseJoinColumns = @JoinColumn(name = "sub_id", referencedColumnName = "id"))
	private List<Subject> subjects;

}
