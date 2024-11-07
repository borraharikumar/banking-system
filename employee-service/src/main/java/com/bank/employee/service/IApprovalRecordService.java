package com.bank.employee.service;

import java.util.List;

import com.bank.employee.dto.ApprovalRecordDto;

public interface IApprovalRecordService {
	
	public ApprovalRecordDto saveApprovalRecord(ApprovalRecordDto dto);
	public ApprovalRecordDto getApprovalRecord(Integer id);
	public List<ApprovalRecordDto> getEmployeeApprovalRecords(Integer empId);
	
}
