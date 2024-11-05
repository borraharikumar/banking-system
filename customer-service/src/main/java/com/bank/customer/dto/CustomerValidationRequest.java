package com.bank.customer.dto;

import lombok.Data;

@Data
public class CustomerValidationRequest {
	
	private Long customerId;
	private String password;

}
