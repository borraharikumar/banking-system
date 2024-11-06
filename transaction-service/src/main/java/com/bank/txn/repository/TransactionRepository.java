package com.bank.txn.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bank.txn.entity.TransactionRecord;

public interface TransactionRepository extends JpaRepository<TransactionRecord, String> {
	
	@Query("SELECT t FROM TransactionRecord t WHERE t.accountNo=:accNo")
	public List<TransactionRecord> getAccountTransactions(Long accNo);
	
	@Query("SELECT t FROM TransactionRecord t WHERE t.accountNo=:accNo AND t.txnType=:txnType")
	public List<TransactionRecord> getAccountTransactions(Long accNo, String txnType);
	
	@Query("SELECT t FROM TransactionRecord t WHERE t.accountNo=:accNo AND t.timestamp BETWEEN :fromDate AND :toDate")
	public List<TransactionRecord> getAccountTransactions(Long accNo, LocalDateTime fromDate, LocalDateTime toDate);
	
	@Query("SELECT t FROM TransactionRecord t WHERE t.refNumber=:refNo")
	public List<TransactionRecord> getTransactionRecordsByRefNo(String refNo);
	
	@Query("SELECT t FROM TransactionRecord t WHERE t.accountNo=:accNo AND t.status=:status")
	public List<TransactionRecord> getTransactionRecordsByStatus(Long accNo, String status);
	
}
