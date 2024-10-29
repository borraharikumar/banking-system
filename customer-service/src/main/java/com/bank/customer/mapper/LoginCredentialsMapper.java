package com.bank.customer.mapper;

import org.springframework.stereotype.Component;

import com.bank.customer.dto.LoginCredentialsDto;
import com.bank.customer.entity.LoginCredentials;

@Component
public class LoginCredentialsMapper {
	
	public LoginCredentials mapToLoginCredentials(LoginCredentialsDto dto) {
		LoginCredentials credentials = new LoginCredentials();
		credentials.setPassword(dto.getPassword());
		credentials.setLoginAttempts(dto.getLoginAttempts());
		credentials.setIsLocked(dto.getIsLocked());
		return credentials;
	}
	
	public LoginCredentialsDto mapToLoginCredentialsDto(LoginCredentials credentials) {
		LoginCredentialsDto dto = new LoginCredentialsDto();
		dto.setPassword(credentials.getPassword());
		dto.setLoginAttempts(credentials.getLoginAttempts());
		dto.setIsLocked(credentials.getIsLocked());
		return dto;
	}

}
