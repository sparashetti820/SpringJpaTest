package com.springjpa.entities;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(uniqueConstraints = @UniqueConstraint(name = "emailId_unique",columnNames = "email_id"))
@ToString(exclude = "department")
public class HeadOfDepartment {
	
	@Id
	@SequenceGenerator(name = "hod_id_generator",sequenceName = "hod_id_generator",allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "hod_id_generator")
	private Integer id;
	
	@Nonnull
	private String firstName;
	
	@Nonnull
	private String lastName;
	
	private String emailId;
	
	private String contactNumber;
	
	@Nonnull
	private String qualification;
	
	@OneToOne
	@JoinColumn(name = "dept_id",referencedColumnName = "id",nullable = false)
	private Department department;

}
