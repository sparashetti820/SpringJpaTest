package com.springjpa.entities;

import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(uniqueConstraints = @UniqueConstraint(name="emailId_unique",columnNames = {"emailId","collegeContact"}))
public class College {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Nonnull
	private String collegeName;
	
	private String address;
	
	@Nonnull
	private String universitySerialNumber;
	
	@Nonnull
	private String emailId;
	
	@Nonnull
	private String collegeContact;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate foundedOn;
	
	

}
