package com.bank.employee.mapper;

import org.springframework.stereotype.Component;

import com.bank.employee.dto.ApprovalRecordDto;
import com.bank.employee.entity.ApprovalRecord;

@Component
public class ApprovalRecordMapper {
	
	public ApprovalRecord mapToApprovalRecord(ApprovalRecordDto dto) {
		ApprovalRecord approval = new ApprovalRecord();
		if(dto.getApprovalId()!=null)
			approval.setApprovalId(dto.getApprovalId());
		approval.setEmployeeId(dto.getEmployeeId());
		approval.setApprovalDate(dto.getApprovalDate());
		approval.setEntityType(dto.getEntityType());
		approval.setEntityId(dto.getEntityId());
		approval.setStatus(dto.getStatus());
		approval.setComment(dto.getComment());
		return approval;
	}
	
	public ApprovalRecordDto mapToApprovalRecordDto(ApprovalRecord approval) {
		ApprovalRecordDto dto = new ApprovalRecordDto();
		dto.setApprovalId(approval.getApprovalId());
		dto.setEmployeeId(approval.getEmployeeId());
		dto.setApprovalDate(approval.getApprovalDate());
		dto.setEntityType(approval.getEntityType());
		dto.setEntityId(approval.getEntityId());
		dto.setStatus(approval.getStatus());
		dto.setComment(approval.getComment());
		return dto;
	}

}
