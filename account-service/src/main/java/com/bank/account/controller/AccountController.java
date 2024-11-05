package com.bank.account.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.bank.account.dto.AccountDto;
import com.bank.account.dto.AccountOpeningRequest;
import com.bank.account.dto.CustomerValidationRequest;
import com.bank.account.dto.MoneyDepositRequest;
import com.bank.account.dto.MoneyDepositResponse;
import com.bank.account.dto.MoneyTransferRequest;
import com.bank.account.dto.MoneyTransferResponse;
import com.bank.account.dto.MoneyWithdrawRequest;
import com.bank.account.dto.MoneyWithdrawResponse;
import com.bank.account.exception.InvalidCredentialsException;
import com.bank.account.exception.InvalidCustomerException;
import com.bank.account.service.IAccountService;

@RestController
@RequestMapping("/accounts")
public class AccountController {
	
	@Autowired private IAccountService accountService;
	@Autowired private RestTemplate restTemplate;
	@Autowired private PasswordEncoder passwordEncoder;
	
	@PostMapping("/new")
	public ResponseEntity<AccountDto> openNewAccount(@RequestBody AccountOpeningRequest openingRequest) {
		AccountDto dto = openingRequest.getAccount();
		CustomerValidationRequest valReq = new CustomerValidationRequest(dto.getCustomerId(), openingRequest.getCustPassword());
		if(restTemplate.postForObject("http://localhost:9002/customers/validate", valReq, Boolean.class)) {
			dto.setTxnPassword(passwordEncoder.encode(dto.getTxnPassword()));
			return ResponseEntity.status(HttpStatus.CREATED)
								 .body(accountService.createAccount(dto));
		} else {
			throw new InvalidCustomerException("Customer credentials/details are invalid..!");
		}
	}
	
	@PutMapping("/deposit")
	public MoneyDepositResponse depositMoney(@RequestBody MoneyDepositRequest depositRequest) {
		MoneyDepositResponse depositResponse = accountService.moneyDeposit(depositRequest);
		depositResponse.setRefNumber(UUID.randomUUID().toString());
		depositResponse.setTxnNumber(null);
		return depositResponse;
	}
	
	@PutMapping("/withdraw")
	public MoneyWithdrawResponse withdrawMoney(@RequestBody MoneyWithdrawRequest withdrawRequest) throws Exception {
		if(passwordEncoder.matches(withdrawRequest.getTxnPassword(), accountService.getPassword(withdrawRequest.getAccountNo()))) {
			MoneyWithdrawResponse withdrawResponse = accountService.moneyWithdraw(withdrawRequest);
			withdrawResponse.setRefNumber(UUID.randomUUID().toString());
			withdrawResponse.setTxnNumber(null);
			return withdrawResponse;
		} else {
			throw new InvalidCredentialsException("Entered account number or password is incorrect...!");
		}
	}
	
	@PutMapping("/transfer")
	public MoneyTransferResponse transferMoney(@RequestBody MoneyTransferRequest transferRequest) {
		if(passwordEncoder.matches(transferRequest.getTxnPassword(), accountService.getPassword(transferRequest.getHostAccountNo()))) {
			MoneyTransferResponse transferResponse = accountService.moneyTransfer(transferRequest);
			transferResponse.setHostAccountTxnNumber(null);
			transferResponse.setBeneAccountTxnNumber(null);
			transferResponse.setRefNumber(UUID.randomUUID().toString());
			return transferResponse;
		} else {
			throw new InvalidCredentialsException("Entered account number or password is incorrect...!");
		}
	}
	
	@GetMapping("/{accNo}")
	public ResponseEntity<AccountDto> getAccount(@PathVariable Long accNo) {
		return ResponseEntity.ok(accountService.getAccount(accNo));
	}

}
