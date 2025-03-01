package com.springjpa.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class Subject {
	
	@Id
	@SequenceGenerator(name = "subject_id_generator",sequenceName = "subject_id_generator",allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "subject_id_generator")
	private Long id;
	
	private String subjectName;
	
	private int rating;
	
	

}
