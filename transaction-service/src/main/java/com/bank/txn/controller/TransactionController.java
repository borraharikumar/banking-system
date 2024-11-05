package com.bank.txn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

}
