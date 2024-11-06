package com.bank.txn.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.txn.entity.TransactionRecord;
import com.bank.txn.repository.service.ITransactionService;

@RestController
@RequestMapping("/txn")
public class TransactionController {
	
	@Autowired private ITransactionService txnService;
	
	@PostMapping("/create")
	public ResponseEntity<String> createTxnRecord(@RequestBody TransactionRecord txnRecord) {
		return ResponseEntity.status(HttpStatus.CREATED)
							 .body(txnService.saveTransactionRecord(txnRecord));
	}
	
	@GetMapping("/{accNo}")
	public ResponseEntity<List<TransactionRecord>> getAccountTransactions(@PathVariable Long accNo) {
		return ResponseEntity.ok(txnService.getTransactionRecordsByAccountNo(accNo));
	}
	
	@GetMapping("/{accNo}/{txnType}")
	public ResponseEntity<List<TransactionRecord>> getAccountTransactions(@PathVariable Long accNo, String txnType) {
		return ResponseEntity.ok(txnService.getTransactionRecordsByAccountNo(accNo, txnType));
	}
	
	@GetMapping("/{accNo}/{fromDate}/{toDate}")
	public ResponseEntity<List<TransactionRecord>> getAccountTransactions(@PathVariable Long accNo,
						@PathVariable @DateTimeFormat(iso = ISO.DATE_TIME) LocalDateTime fromDate,
						@PathVariable @DateTimeFormat(iso = ISO.DATE_TIME) LocalDateTime toDate) {
		return ResponseEntity.ok(txnService.getTransactionRecordsByAccountNo(accNo, fromDate, toDate));
	}
	
	@GetMapping("/refNo/{refNo}")
	public ResponseEntity<List<TransactionRecord>> getTransactionRecordsByRefNo(String refNo) {
		return ResponseEntity.ok(txnService.getTransactionRecordsByRefNo(refNo));
	}
	
	@GetMapping("/{accNo}/status/{status}")
	public ResponseEntity<List<TransactionRecord>> getTransactionRecordsByStatus(Long accNo, String status) {
		return ResponseEntity.ok(txnService.getTransactionRecordsByStatus(accNo, status));
	}

}
