package com.bank.account.dto;

import lombok.Data;

@Data
public class AccountOpeningRequest {
	
	private AccountDto account;
	private String custPassword;

}
