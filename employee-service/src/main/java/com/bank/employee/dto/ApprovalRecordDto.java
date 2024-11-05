package com.bank.employee.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ApprovalRecordDto {
	
	private Integer approvalId;
	private Integer employeeId;
	private LocalDate approvalDate;
	private String entityType;	// Loan/Card/Account
	private Long entityId;
	private String status;
	private String comment;

}
