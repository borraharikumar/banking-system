package com.bank.account.dto;

import lombok.Data;

@Data
public class MoneyDepositResponse {
	
	private Long accountNo;
	private Double previousBalance;
	private Double creditedAmount;
	private Double currentBalance;
	private String depositedBy;
	private String status;
	private String txnNumber;
	private String refNumber;

}
