package com.bank.customer.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bank.customer.dto.CustomerDto;
import com.bank.customer.entity.Customer;

@Component
public class CustomerMapper {
	
	@Autowired private CustomerProfileMapper customerProfileMapper;
	@Autowired private CustomerIdentitiesMapper customerIdentitiesMapper;
	@Autowired private CustomerContactMapper customerContactMapper;
	@Autowired private CustomerAddressMapper customerAddressMapper;
	@Autowired private LoginCredentialsMapper loginCredentialsMapper;
	
	public Customer mapToCustomer(CustomerDto dto) {
		Customer customer = new Customer();
		if(dto.getCustomerId()!=null) customer.setCustomerId(dto.getCustomerId());
		customer.setCustomerProfile(customerProfileMapper.mapToCustomerProfile(dto.getCustomerProfile()));
		customer.setCustomerIdentities(customerIdentitiesMapper.mapToCustomerIdentities(dto.getCustomerIdentities()));
		customer.setCustomerContact(customerContactMapper.mapToCustomerContact(dto.getCustomerContact()));
		customer.setCustomerAddress(customerAddressMapper.mapToCustomerAddress(dto.getCustomerAddress()));
		customer.setLoginCredentials(loginCredentialsMapper.mapToLoginCredentials(dto.getLoginCredentials()));
		return customer;
	}
	
	public CustomerDto mapToCustomerDto(Customer customer) {
		CustomerDto dto = new CustomerDto();
		dto.setCustomerId(customer.getCustomerId());
		dto.setCustomerProfile(customerProfileMapper.mapToCustomerProfileDto(customer.getCustomerProfile()));
		dto.setCustomerIdentities(customerIdentitiesMapper.mapToCustomerIdentitiesDto(customer.getCustomerIdentities()));
		dto.setCustomerContact(customerContactMapper.mapToCustomerContactDto(customer.getCustomerContact()));
		dto.setCustomerAddress(customerAddressMapper.mapToCustomerAddressDto(customer.getCustomerAddress()));
		dto.setLoginCredentials(loginCredentialsMapper.mapToLoginCredentialsDto(customer.getLoginCredentials()));
		return dto;
	}

}
