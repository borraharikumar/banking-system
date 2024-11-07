package com.bank.employee.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class CardApplication {
	
	private Integer applicationNo;
	private Long accountNo;
	private String cardType;
	private LocalDate applicationDate;
	private String status;		// APPLIED/ISSUED/REJECTED

}
