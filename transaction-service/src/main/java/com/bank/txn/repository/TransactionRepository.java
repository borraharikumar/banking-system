package com.bank.txn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.txn.entity.TransactionRecord;

public interface TransactionRepository extends JpaRepository<TransactionRecord, String> {

}
