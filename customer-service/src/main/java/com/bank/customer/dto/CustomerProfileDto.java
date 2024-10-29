package com.bank.customer.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class CustomerProfileDto {
	
	private String firstName;
	private String lastName;
	private LocalDate dateOfBirth;
	private String occupation;
	private String maritalStatus;
	private Double annualIncome;

}
