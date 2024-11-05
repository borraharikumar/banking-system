package com.bank.account.dto;

import lombok.Data;

@Data
public class MoneyTransferRequest {
	
	private Long hostAccountNo;
	private Long beneAccountNo;
	private Double amount;
	private String txnPassword;

}
