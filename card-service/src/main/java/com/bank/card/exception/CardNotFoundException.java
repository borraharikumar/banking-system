package com.bank.card.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(reason = "Card details not found", code = HttpStatus.NOT_FOUND, value = HttpStatus.NOT_FOUND)
public class CardNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 676505124483294011L;
	
	public CardNotFoundException() {
		super();
	}
	
	public CardNotFoundException(String message) {
		super(message);
	}

}
