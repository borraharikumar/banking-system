package com.bank.employee.mapper;

import org.springframework.stereotype.Component;

import com.bank.employee.dto.EmployeeDto;
import com.bank.employee.entity.Employee;

@Component
public class EmployeeMapper {
	
	public Employee mapToEmployee(EmployeeDto dto) {
		Employee employee = new Employee();
		if(dto.getEmployeeId()!=null)
			employee.setEmployeeId(dto.getEmployeeId());
		employee.setFirstName(dto.getFirstName());
		employee.setLastName(dto.getLastName());
		employee.setRole(dto.getRole());
		employee.setEmail(dto.getEmail());
		employee.setMobileNo(dto.getMobileNo());
		employee.setDepartment(dto.getDepartment());
		employee.setAssignedBranch(dto.getAssignedBranch());
		employee.setPassword(dto.getPassword());
		return employee;
	}
	
	public EmployeeDto mapToEmployeeDto(Employee employee) {
		EmployeeDto dto = new EmployeeDto();
		dto.setEmployeeId(employee.getEmployeeId());
		dto.setFirstName(employee.getFirstName());
		dto.setLastName(employee.getLastName());
		dto.setRole(employee.getRole());
		dto.setEmail(employee.getEmail());
		dto.setMobileNo(employee.getMobileNo());
		dto.setDepartment(employee.getDepartment());
		dto.setAssignedBranch(employee.getAssignedBranch());
		dto.setPassword(employee.getPassword());
		return dto;
	}

}
