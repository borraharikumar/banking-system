package com.bank.employee.service;

import com.bank.employee.dto.EmployeeDto;

public interface IEmployeeService {
	
	public EmployeeDto saveEmployee(EmployeeDto dto);
	public EmployeeDto getEmployee(Integer id);
	public EmployeeDto updateEmployee(EmployeeDto dto);
	public String deleteEmployee(Integer id);

}
