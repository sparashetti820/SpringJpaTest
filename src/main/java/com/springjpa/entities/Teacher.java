package com.springjpa.entities;

import java.util.List;

import jakarta.annotation.Nonnull;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Teacher {

	@Id
	@SequenceGenerator(name = "teacher_id_generator", sequenceName = "teacher_id_generator", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "teacher_id_generator")
	private Long id;

	@Nonnull
	private String firstName;

	@Nonnull
	private String lastName;

	private String emailId;

	private String contactNumber;

	@Nonnull
	private String qualification;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "dpt_id", referencedColumnName = "id")
	private Department department;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "teacher_sub_map", joinColumns = @JoinColumn(name = "teacher_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "subject_id", referencedColumnName = "id"))
	private List<Subject> subjects;
}
