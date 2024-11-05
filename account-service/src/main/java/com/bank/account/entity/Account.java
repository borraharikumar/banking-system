package com.bank.account.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "account_tab")
public class Account {
	
	@Id
	@GeneratedValue(generator = "account_id_gen", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name="account_id_gen", sequenceName="account_id_seq", initialValue=1000000000, allocationSize=1)
	private Long accountNo;
	private Long customerId;
	private String accountType;
	private Double balance;
	private LocalDate createdDate;
	private LocalDateTime lastTxnDate;
	private String status;
	private String txnPassword;

}
