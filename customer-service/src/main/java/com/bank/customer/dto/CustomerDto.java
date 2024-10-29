package com.bank.customer.dto;

import lombok.Data;

@Data
public class CustomerDto {
	
	private Long customerId;
	private CustomerProfileDto customerProfile;
	private CustomerIdentitiesDto customerIdentities;
	private CustomerContactDto customerContact;
	private CustomerAddressDto customerAddress;
	private LoginCredentialsDto loginCredentials;

}
