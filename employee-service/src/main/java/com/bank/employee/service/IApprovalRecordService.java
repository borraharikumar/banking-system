package com.bank.employee.service;

import com.bank.employee.dto.ApprovalRecordDto;

public interface IApprovalRecordService {
	
	public ApprovalRecordDto saveApprovalRecord(ApprovalRecordDto dto);
	public ApprovalRecordDto getApprovalRecord(Integer id);
	public ApprovalRecordDto updateApprovalRecord(ApprovalRecordDto dto);
	
}
