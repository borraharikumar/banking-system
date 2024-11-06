package com.bank.card.entity;

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
@Table(name = "card_application_tab")
public class CardApplication {
	
	@Id
	@GeneratedValue(generator = "app_id_gen", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name="app_id_gen", sequenceName="card_application_id_seq", initialValue=10000, allocationSize=1)
	private Integer applicationNo;
	private Long accountNo;
	private String cardType;
	private LocalDate applicationDate;
	private String status;		// APPLIED/ISSUED/REJECTED

}
