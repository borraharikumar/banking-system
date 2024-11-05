package com.bank.txn.repository.service;

import java.time.LocalDate;
import java.util.List;

import com.bank.txn.entity.TransactionRecord;

public interface ITransactionService {
	
	public String saveTransactionRecord(TransactionRecord txnRecord);
	public List<TransactionRecord> getTransactionRecordsByAccountNo(Long accNo);
	public List<TransactionRecord> getTransactionRecordsByAccountNo(Long accNo, String txnType);
	public List<TransactionRecord> getTransactionRecordsByAccountNo(Long accNo, LocalDate fromDate, LocalDate toDate);
	public List<TransactionRecord> getTransactionRecordsByRefNo(String refNo);
	public List<TransactionRecord> getTransactionRecordsByStatus(String status);
	public TransactionRecord getTransactionRecord(Long txnNo);
}
