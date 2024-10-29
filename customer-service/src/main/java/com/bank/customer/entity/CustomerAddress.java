package com.bank.customer.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "customer_address_tab")
public class CustomerAddress {
	
	@Id
	@GeneratedValue(generator="cust_addr_id_gen", strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="cust_addr_id_gen", sequenceName="customer_address_id_seq", initialValue=1, allocationSize=1)
	private Integer id;
	private String houseNo;
	private String street;
	private String city;
	private String district;
	private String state;
	private String country;
	private String zipcode;

}
