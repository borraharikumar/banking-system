package com.bank.customer.dto;

import lombok.Data;

@Data
public class LoginCredentialsDto {
	
	private String password;
	private Integer loginAttempts;
	private Boolean isLocked;

}
