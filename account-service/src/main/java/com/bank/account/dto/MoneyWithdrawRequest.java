package com.bank.account.dto;

import lombok.Data;

@Data
public class MoneyWithdrawRequest {
	
	private Long accountNo;
	private Double amount;
	private String txnPassword;

}
