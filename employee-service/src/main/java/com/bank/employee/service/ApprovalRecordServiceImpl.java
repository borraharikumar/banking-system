package com.bank.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.employee.dto.ApprovalRecordDto;
import com.bank.employee.exception.ApprovalRecordNotFoundExceion;
import com.bank.employee.mapper.ApprovalRecordMapper;
import com.bank.employee.repository.ApprovalRecordRepository;

@Service
public class ApprovalRecordServiceImpl implements IApprovalRecordService {

	@Autowired private ApprovalRecordRepository recordRepository;
	@Autowired private ApprovalRecordMapper recordMapper;

	@Override
	public ApprovalRecordDto saveApprovalRecord(ApprovalRecordDto dto) {
		return recordMapper.mapToApprovalRecordDto(recordRepository.save(recordMapper.mapToApprovalRecord(dto)));
	}

	@Override
	public ApprovalRecordDto getApprovalRecord(Integer id) {
		return recordMapper.mapToApprovalRecordDto(recordRepository.findById(id)
					.orElseThrow(()->new ApprovalRecordNotFoundExceion())
				);
	}

	@Override
	public List<ApprovalRecordDto> getEmployeeApprovalRecords(Integer empId) {
		return recordRepository.getEmployeeApprovalRecords(empId)
							   .stream().map(ar->recordMapper.mapToApprovalRecordDto(ar))
							   .toList();
	}

}
