package com.bank.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.employee.dto.EmployeeDto;
import com.bank.employee.service.IEmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired private IEmployeeService employeeService;
	@Autowired private PasswordEncoder passwordEncoder;
	
	@PostMapping
	public ResponseEntity<EmployeeDto> insertEmployee(@RequestBody EmployeeDto dto) {
		dto.setPassword(passwordEncoder.encode(dto.getPassword()));
		return ResponseEntity.status(HttpStatus.CREATED)
							 .body(employeeService.saveEmployee(dto));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<EmployeeDto> getEmployee(@PathVariable Integer id) {
		return ResponseEntity.ok(employeeService.getEmployee(id));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable Integer id) {
		return ResponseEntity.ok(employeeService.deleteEmployee(id));
	}
	
	@PutMapping
	public ResponseEntity<EmployeeDto> updateEmployee(@RequestBody EmployeeDto dto) {
		dto.setPassword(passwordEncoder.encode(dto.getPassword()));
		return ResponseEntity.ok(employeeService.updateEmployee(dto));
	}

}
