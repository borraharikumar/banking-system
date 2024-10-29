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
@Table(name = "customer_identities_tab")
public class CustomerIdentities {
	
	@Id
	@GeneratedValue(generator="cust_ids_id_gen", strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="cust_ids_id_gen", sequenceName="customer_identities_id_seq", initialValue=1, allocationSize=1)
	private Integer id;
	private Long aadhar;
	private String pan;
	private String voterId;

}
