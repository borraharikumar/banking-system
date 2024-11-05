package com.bank.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.employee.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
