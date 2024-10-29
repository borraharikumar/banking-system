package com.bank.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.customer.dto.CustomerDto;
import com.bank.customer.service.ICustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	@Autowired private ICustomerService customerService;
	
	@PostMapping("/register")
	public ResponseEntity<CustomerDto> registerCustomer(@RequestBody CustomerDto dto) {
		return ResponseEntity.status(HttpStatus.CREATED)
							 .body(customerService.saveCustomer(dto));
	}
	
	@GetMapping("/retrieve/{id}")
	public ResponseEntity<CustomerDto> getCustomer(@PathVariable Long id) {
		return ResponseEntity.ok(customerService.getCustomer(id));
	}
	
	@PutMapping("/update")
	public ResponseEntity<CustomerDto> updateCustomer(@RequestBody CustomerDto dto) {
		return ResponseEntity.ok(customerService.updateCustomer(dto));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable Long id) {
		return ResponseEntity.ok(customerService.deleteCustomer(id));
	}

}
