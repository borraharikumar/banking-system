package com.bank.account.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Invalid credentials")
public class InvalidCredentialsException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public InvalidCredentialsException() {
		super();
	}
	
	public InvalidCredentialsException(String message) {
		super(message);
	}

}
