package com.bank.account.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class AccountDto {
	
	private Long accountNo;
	private Long customerId;
	private String accountType;
	private Double balance;
	private LocalDate createdDate;
	private LocalDateTime lastTxnDate;
	private String status;
	private String txnPassword;

}
