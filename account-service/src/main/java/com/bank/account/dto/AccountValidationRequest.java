package com.bank.account.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountValidationRequest {
	
	private Long accountNo;
	private String password;

}
