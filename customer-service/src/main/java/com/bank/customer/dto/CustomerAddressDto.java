package com.bank.customer.dto;

import lombok.Data;

@Data
public class CustomerAddressDto {
	
	private String houseNo;
	private String street;
	private String city;
	private String district;
	private String state;
	private String country;
	private String zipcode;

}
