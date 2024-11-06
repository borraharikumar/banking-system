package com.bank.txn.repository.service;

import java.time.LocalDateTime;
import java.util.List;

import com.bank.txn.entity.TransactionRecord;

public interface ITransactionService {

	public String saveTransactionRecord(TransactionRecord txnRecord);
	public List<TransactionRecord> getTransactionRecordsByAccountNo(Long accNo);
	public List<TransactionRecord> getTransactionRecordsByAccountNo(Long accNo, String txnType);
	public List<TransactionRecord> getTransactionRecordsByAccountNo(Long accNo, LocalDateTime fromDate, LocalDateTime toDate);
	public List<TransactionRecord> getTransactionRecordsByRefNo(String refNo);
	public List<TransactionRecord> getTransactionRecordsByStatus(Long accNo, String status);
	public TransactionRecord getTransactionRecord(String txnNo);

}
