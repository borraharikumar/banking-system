package com.bank.card.controller;

import java.time.LocalDate;
import java.util.List;

import org.apache.hc.client5.http.auth.InvalidCredentialsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.bank.card.dto.AccountValidationRequest;
import com.bank.card.dto.CardApplicationRequest;
import com.bank.card.entity.CardApplication;
import com.bank.card.service.ICardApplicationService;

@RestController
@RequestMapping("/card/application")
public class CardApplicationController {
	
	@Autowired private ICardApplicationService applicationService;
	@Autowired private RestTemplate restTemplate;
	
	@PostMapping("/new")
	public Integer cardApplication(@RequestBody CardApplicationRequest application) throws Exception {
		AccountValidationRequest valRequest =
				new AccountValidationRequest(application.getCardApplication().getAccountNo(), application.getTxnPassword());
		if(restTemplate.postForObject("http://localhost:9003/accounts/validate", valRequest, Boolean.class)) {
			return applicationService.insertCardApplication(application.getCardApplication());
		} else {
			throw new InvalidCredentialsException("Invalid account credentials");
		}
	}
	
	@GetMapping
	public ResponseEntity<List<CardApplication>> getCardApplication() {
		return ResponseEntity.ok(applicationService.getCardApplications());
	}
	
	@PutMapping("/update")
	public String updateCardApplicationStatus(Integer applicationNo, String status) {
		return applicationService.updateCardApplicationStatus(applicationNo, status);
	}
	
	@GetMapping("/{applicationNo}")
	public ResponseEntity<CardApplication> getCardApplication(@PathVariable Integer applicationNo) {
		return ResponseEntity.ok(applicationService.getCardApplication(applicationNo));
	}
	
	@GetMapping("/status/{status}")
	public ResponseEntity<List<CardApplication>> getCardApplication(@PathVariable String status) {
		return ResponseEntity.ok(applicationService.getCardApplicationsByStatus(status));
	}
	
	@GetMapping("/account/{accNo}")
	public ResponseEntity<List<CardApplication>> getCardApplication(@PathVariable Long accNo) {
		return ResponseEntity.ok(applicationService.getCardApplicationsByAccountNo(accNo));
	}
	
	@GetMapping("/date/{applicationDate}")
	public ResponseEntity<List<CardApplication>> getCardApplication(@PathVariable LocalDate applicationDate) {
		return ResponseEntity.ok(applicationService.getCardApplicationsByApplicatioDate(applicationDate));
	}
	
	@GetMapping("/date/{fromDate}/{toDate}")
	public ResponseEntity<List<CardApplication>> getCardApplication(@PathVariable LocalDate fromDate, @PathVariable LocalDate toDate) {
		return ResponseEntity.ok(applicationService.getCardApplicationsByApplicatioDate(fromDate, toDate));
	}

}
