package com.bank.customer.mapper;

import org.springframework.stereotype.Component;

import com.bank.customer.dto.CustomerProfileDto;
import com.bank.customer.entity.CustomerProfile;

@Component
public class CustomerProfileMapper {
	
	public CustomerProfile mapToCustomerProfile(CustomerProfileDto dto) {
		CustomerProfile profile = new CustomerProfile();
		profile.setFirstName(dto.getFirstName());
		profile.setLastName(dto.getLastName());
		profile.setDateOfBirth(dto.getDateOfBirth());
		profile.setOccupation(dto.getOccupation());
		profile.setMaritalStatus(dto.getMaritalStatus());
		profile.setAnnualIncome(dto.getAnnualIncome());
		return profile;
	}
	
	public CustomerProfileDto mapToCustomerProfileDto(CustomerProfile profile) {
		CustomerProfileDto dto = new CustomerProfileDto();
		dto.setFirstName(profile.getFirstName());
		dto.setLastName(profile.getLastName());
		dto.setDateOfBirth(profile.getDateOfBirth());
		dto.setOccupation(profile.getOccupation());
		dto.setMaritalStatus(profile.getMaritalStatus());
		dto.setAnnualIncome(profile.getAnnualIncome());
		return dto;
	}

}
