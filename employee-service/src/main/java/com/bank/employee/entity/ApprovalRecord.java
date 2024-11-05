package com.bank.employee.entity;

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
@Table(name = "approval_record_tab")
public class ApprovalRecord {
	
	@Id
	@GeneratedValue(generator="app_id_gen", strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="app_id_gen", sequenceName="approval_id_seq", initialValue=10000, allocationSize=1)
	private Integer approvalId;
	private Integer employeeId;
	private LocalDate approvalDate;
	private String entityType;	// Loan/Card/Account
	private Long entityId;
	private String status;
	private String comment;

}
