package com.bank.account.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Invalid customer login credentials")
public class InvalidCustomerException extends RuntimeException {

	private static final long serialVersionUID = -2998866716800156101L;
	
	public InvalidCustomerException() {
		super();
	}
	
	public InvalidCustomerException(String message) {
		super(message);
	}

}
