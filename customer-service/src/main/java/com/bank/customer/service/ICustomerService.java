package com.bank.customer.service;

import com.bank.customer.dto.CustomerDto;

public interface ICustomerService {
	
	public CustomerDto saveCustomer(CustomerDto dto);
	public CustomerDto getCustomer(Long custId);
	public CustomerDto updateCustomer(CustomerDto dto);
	public String deleteCustomer(Long custId);
	public Boolean validateCustomer(Long customerId, String password);

}
