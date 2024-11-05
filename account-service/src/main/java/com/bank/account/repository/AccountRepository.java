package com.bank.account.repository;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bank.account.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
	
	@Query("SELECT balance FROM Account WHERE accountNo=:accNo")
	public Double getAccountBalance(Long accNo);
	
	@Query("UPDATE Account SET balance=:balance WHERE accountNo=:accNo")
	public void updateAccountBalance(Long accNo, Double balance);
	
	@Query("UPDATE Account SET status='CLOSED' WHERE accountNo=:accNo")
	public void closeAccount(Long accNo);
	
	@Query("SELECT txnPassword FROM Account WHERE accountNo=:accNo")
	public String getTxnPassword(Long accNo);
	
	@Query("UPDATE Account SET lastTxnDate=:timestamp WHERE accountNo=:accNo")
	public void updateLastTxnTimestamp(Long accNo, LocalDateTime timestamp);

}
