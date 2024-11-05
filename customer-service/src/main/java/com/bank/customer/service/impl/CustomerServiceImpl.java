package com.bank.customer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bank.customer.dto.CustomerDto;
import com.bank.customer.exception.CustomerNotFoundException;
import com.bank.customer.mapper.CustomerMapper;
import com.bank.customer.repository.CustomerRepository;
import com.bank.customer.service.ICustomerService;

@Service
public class CustomerServiceImpl implements ICustomerService {
	
	@Autowired private CustomerRepository customerRepository;
	@Autowired private CustomerMapper customerMapper;
	@Autowired private PasswordEncoder passwordEncoder;

	@Override
	public CustomerDto saveCustomer(CustomerDto dto) {
		dto.getLoginCredentials().setPassword(passwordEncoder.encode(dto.getLoginCredentials().getPassword()));
		return customerMapper.mapToCustomerDto(customerRepository.save(customerMapper.mapToCustomer(dto)));
	}

	@Override
	public CustomerDto getCustomer(Long custId) {
		return customerMapper.mapToCustomerDto(
					customerRepository.findById(custId)
						.orElseThrow(()->new CustomerNotFoundException("Customer not found with id '" + custId + "'"))
			   );
	}

	@Override
	public CustomerDto updateCustomer(CustomerDto dto) {
		getCustomer(dto.getCustomerId());
		return saveCustomer(dto);
	}

	@Override
	public String deleteCustomer(Long custId) {
		getCustomer(custId);
		customerRepository.deleteById(custId);
		return "Customer with id '" + custId + "' deleted successfully...!";
	}

	@Override
	public Boolean validateCustomer(Long customerId, String password) {
		return passwordEncoder.matches(password, customerRepository.getCountOfCustomers(customerId));
	}

}
