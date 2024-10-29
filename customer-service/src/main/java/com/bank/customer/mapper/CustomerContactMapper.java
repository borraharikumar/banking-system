package com.bank.customer.mapper;

import org.springframework.stereotype.Component;

import com.bank.customer.dto.CustomerContactDto;
import com.bank.customer.entity.CustomerContact;

@Component
public class CustomerContactMapper {
	
	public CustomerContact mapToCustomerContact(CustomerContactDto dto) {
		CustomerContact contact = new CustomerContact();
		contact.setEmail(dto.getEmail());
		contact.setMobileNo(dto.getMobileNo());
		return contact;
	}
	
	public CustomerContactDto mapToCustomerContactDto(CustomerContact contact) {
		CustomerContactDto dto = new CustomerContactDto();
		dto.setEmail(contact.getEmail());
		dto.setMobileNo(contact.getMobileNo());
		return dto;
	}

}
