package com.bank.account.dto;

import lombok.Data;

@Data
public class MoneyWithdrawResponse {
	
	private Long accountNo;
	private Double previousBalance;
	private Double debitedAmount;
	private Double currentBalance;
	private String status;
	private Long txnNumber;
	private String refNumber;

}
