package com.bank.account.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class TransactionRecord {
	
	private Long txnId;
	private Long accountNo;
	private Double amount;
	private String txnType;
	private LocalDateTime timestamp;
	private String txnMode;
	private String status;
	private String refNumber;

}
