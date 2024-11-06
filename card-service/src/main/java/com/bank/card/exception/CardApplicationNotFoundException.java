package com.bank.card.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Card application not found", value = HttpStatus.NOT_FOUND)
public class CardApplicationNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -7200182124564922404L;
	
	public CardApplicationNotFoundException() {
		super();
	}
	
	public CardApplicationNotFoundException(String message) {
		super(message);
	}

}
