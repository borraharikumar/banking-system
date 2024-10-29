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
@Table(name = "customer_login_credentials_tab")
public class LoginCredentials {
	
	@Id
	@GeneratedValue(generator="lc_id_gen", strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="lc_id_gen", sequenceName="customer_login_creds_id_seq", initialValue=1, allocationSize=1)
	private Integer id;
	private String password;
	private Integer loginAttempts;
	private Boolean isLocked;

}
