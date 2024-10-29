package com.bank.customer.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "customer_profile_tab")
public class CustomerProfile {
	
	@Id
	@GeneratedValue(generator="cust_prof_id_gen", strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="cust_prof_id_gen", sequenceName="customer_profile_id_seq", initialValue=1, allocationSize=1)
	private Integer id;
	private String firstName;
	private String lastName;
	private LocalDate dateOfBirth;
	private String occupation;
	private String maritalStatus;
	private Double annualIncome;

}
