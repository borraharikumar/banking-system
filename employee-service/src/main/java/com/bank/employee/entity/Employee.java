package com.bank.employee.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "employee_tab")
public class Employee {
	
	@Id
	@GeneratedValue(generator="emp_id_gen", strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="emp_id_gen", sequenceName="employee_id_seq", initialValue=100000, allocationSize=1)
	private Integer employeeId;
	private String firstName;
	private String lastName;
	private String role;
	private String email;
	private Long mobileNo;
	private String department;
	private String assignedBranch;

}
