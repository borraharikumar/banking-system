package com.bank.customer.mapper;

import org.springframework.stereotype.Component;

import com.bank.customer.dto.CustomerAddressDto;
import com.bank.customer.entity.CustomerAddress;

@Component
public class CustomerAddressMapper {
	
	public CustomerAddress mapToCustomerAddress(CustomerAddressDto dto) {
		CustomerAddress address = new CustomerAddress();
		address.setHouseNo(dto.getHouseNo());
		address.setStreet(dto.getStreet());
		address.setCity(dto.getCity());
		address.setDistrict(dto.getDistrict());
		address.setState(dto.getState());
		address.setCountry(dto.getCountry());
		address.setZipcode(dto.getZipcode());
		return address;
	}
	
	public CustomerAddressDto mapToCustomerAddressDto(CustomerAddress address) {
		CustomerAddressDto dto = new CustomerAddressDto();
		dto.setHouseNo(address.getHouseNo());
		dto.setStreet(address.getStreet());
		dto.setCity(address.getCity());
		dto.setDistrict(address.getDistrict());
		dto.setState(address.getState());
		dto.setCountry(address.getCountry());
		dto.setZipcode(address.getZipcode());
		return dto;
	}

}
