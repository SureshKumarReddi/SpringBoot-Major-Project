package com.suresh.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterUser {

	private String fullName;
	private String email;
	private long mobileNumber;
	private String gender;
	private Date dob;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ssn;
	
}
