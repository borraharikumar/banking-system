package com.bank.account.dto;

import lombok.Data;

@Data
public class MoneyDepositRequest {
	
	private Long accountNo;
	private Double amount;
	private String depositedBy;

}
