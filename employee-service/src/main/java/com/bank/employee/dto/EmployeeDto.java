package com.bank.employee.dto;

import lombok.Data;

@Data
public class EmployeeDto {
	
	private Integer employeeId;
	private String firstName;
	private String lastName;
	private String role;
	private String email;
	private Long mobileNo;
	private String department;
	private String assignedBranch;
	private String password;

}
