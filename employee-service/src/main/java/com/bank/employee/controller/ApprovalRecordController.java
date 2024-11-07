package com.bank.employee.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.bank.employee.dto.ApprovalRecordDto;
import com.bank.employee.dto.CardApplication;
import com.bank.employee.service.IApprovalRecordService;

@RestController
@RequestMapping("/approval-record")
public class ApprovalRecordController {

	@Autowired private IApprovalRecordService recordService;
	@Autowired private RestTemplate restTemplate;

	private String csUrl = "http://localhost:9005/card/";

	@PostMapping("/card/{caNo}/{status}")
	public ResponseEntity<ApprovalRecordDto> saveApprovalRecord(@PathVariable Integer caNo) {
		CardApplication application = restTemplate.postForEntity(csUrl+"application/"+caNo, null, CardApplication.class).getBody();
		ApprovalRecordDto dto = new ApprovalRecordDto();
		dto.setEmployeeId(100000);
		dto.setApprovalDate(LocalDate.now());
		dto.setEntityType("CARD");
		dto.setEntityId(null);
		dto.setStatus("APPROVED");
		dto.setComment("");
		return ResponseEntity.status(HttpStatus.CREATED).body(recordService.saveApprovalRecord(dto));
	}

	@GetMapping("/{id}")
	public ResponseEntity<ApprovalRecordDto> getApprovalRecord(@PathVariable Integer id) {
		return ResponseEntity.ok(recordService.getApprovalRecord(id));
	}

	@GetMapping("/emp/{empId}")
	public ResponseEntity<List<ApprovalRecordDto>> getEmployeeApprovalRecords(@PathVariable Integer empId) {
		return ResponseEntity.ok(recordService.getEmployeeApprovalRecords(empId));
	}

}
