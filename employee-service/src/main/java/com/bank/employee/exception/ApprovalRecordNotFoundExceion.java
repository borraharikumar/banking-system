package com.bank.employee.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Approval record not found", value = HttpStatus.NOT_FOUND)
public class ApprovalRecordNotFoundExceion extends RuntimeException {

	private static final long serialVersionUID = 3753765059411673362L;
	
	public ApprovalRecordNotFoundExceion() {
		super();
	}
	
	public ApprovalRecordNotFoundExceion(String message) {
		super(message);
	}

}
