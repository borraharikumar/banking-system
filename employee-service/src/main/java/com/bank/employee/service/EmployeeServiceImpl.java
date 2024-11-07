package com.bank.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.employee.dto.EmployeeDto;
import com.bank.employee.exception.EmployeeNotFoundException;
import com.bank.employee.mapper.EmployeeMapper;
import com.bank.employee.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
	
	@Autowired private EmployeeRepository employeeRepository;
	@Autowired private EmployeeMapper employeeMapper;

	@Override
	public EmployeeDto saveEmployee(EmployeeDto dto) {
		return employeeMapper.mapToEmployeeDto(employeeRepository.save(employeeMapper.mapToEmployee(dto)));
	}

	@Override
	public EmployeeDto getEmployee(Integer id) {
		return employeeMapper.mapToEmployeeDto(employeeRepository.findById(id)
				.orElseThrow(()->new EmployeeNotFoundException())
			);
	}

	@Override
	public EmployeeDto updateEmployee(EmployeeDto dto) {
		getEmployee(dto.getEmployeeId());
		return saveEmployee(dto);
	}

	@Override
	public String deleteEmployee(Integer id) {
		getEmployee(id);
		employeeRepository.deleteById(id);
		return "";
	}

}
