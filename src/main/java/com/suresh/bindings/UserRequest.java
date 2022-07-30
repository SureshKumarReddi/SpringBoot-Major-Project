package com.suresh.bindings;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {

	private String fullName;
	private String email;
	private long mobileNumber;
	private String gender;
	private Date dob;
	private int ssn;
	
}
