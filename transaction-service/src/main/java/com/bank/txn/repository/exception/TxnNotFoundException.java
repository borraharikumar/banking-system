package com.bank.txn.repository.exception;

public class TxnNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -1013061486036669307L;
	
	public TxnNotFoundException() {
		super();
	}
	
	public TxnNotFoundException(String message) {
		super(message);
	}

}
