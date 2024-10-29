package com.bank.customer.mapper;

import org.springframework.stereotype.Component;

import com.bank.customer.dto.CustomerIdentitiesDto;
import com.bank.customer.entity.CustomerIdentities;

@Component
public class CustomerIdentitiesMapper {
	
	public CustomerIdentities mapToCustomerIdentities(CustomerIdentitiesDto dto) {
		CustomerIdentities identities = new CustomerIdentities();
		identities.setAadhar(dto.getAadhar());
		identities.setPan(dto.getPan());
		identities.setVoterId(dto.getVoterId());
		return identities;
	}
	
	public CustomerIdentitiesDto mapToCustomerIdentitiesDto(CustomerIdentities identities) {
		CustomerIdentitiesDto dto = new CustomerIdentitiesDto();
		dto.setAadhar(identities.getAadhar());
		dto.setPan(identities.getPan());
		dto.setVoterId(identities.getVoterId());
		return dto;
	}

}
