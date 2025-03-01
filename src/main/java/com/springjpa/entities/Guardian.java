package com.springjpa.entities;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
@AttributeOverrides({
	@AttributeOverride(name = "firstName",column =@Column(name="g_first_name")),
	@AttributeOverride(name = "lastName",column =@Column(name="g_last_name")),
	@AttributeOverride(name = "contactNumber",column =@Column(name="g_contact"))
	
})
public class Guardian {
	
	private String firstName;
	
	private String lastName;
	
	private String contactNumber;

}
