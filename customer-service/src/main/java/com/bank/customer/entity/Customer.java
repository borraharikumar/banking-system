package com.bank.customer.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "customer_tab")
public class Customer {
	
	@Id
	@GeneratedValue(generator = "cust_id_gen", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name="cust_id_gen", sequenceName="customer_id_seq", initialValue=1000000, allocationSize=1)
	@Column(name = "cust_id_col")
	private Long customerId;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cust_prof_fk_col")
	private CustomerProfile customerProfile;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cust_idts_fk_col")
	private CustomerIdentities customerIdentities;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cust_cont_fk_col")
	private CustomerContact customerContact;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cust_addr_fk_col")
	private CustomerAddress customerAddress;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cust_login_creds_fk_col")
	private LoginCredentials loginCredentials;

}
