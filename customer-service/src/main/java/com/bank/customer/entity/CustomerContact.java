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
@Table(name = "customer_contact_tab")
public class CustomerContact {
	
	@Id
	@GeneratedValue(generator="cust_cont_id_gen", strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="cust_cont_id_gen", sequenceName="customer_contact_id_seq", initialValue=1, allocationSize=1)
	private Integer id;
	private String email;
	private Long mobileNo;

}
