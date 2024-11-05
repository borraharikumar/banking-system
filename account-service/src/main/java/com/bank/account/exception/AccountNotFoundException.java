package com.bank.account.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class AccountNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -6819180725443797213L;
	
	public AccountNotFoundException() {
		super();
	}
	
	public AccountNotFoundException(String message) {
		super(message);
	}

}
