package com.bank.txn.repository.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.txn.entity.TransactionRecord;
import com.bank.txn.repository.TransactionRepository;

@Service
public class TransactionServiceImpl implements ITransactionService {
	
	@Autowired private TransactionRepository txnRepository;

	@Override
	public String saveTransactionRecord(TransactionRecord txnRecord) {
		return txnRepository.save(txnRecord).getTxnId();
	}

	@Override
	public List<TransactionRecord> getTransactionRecordsByAccountNo(Long accNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TransactionRecord> getTransactionRecordsByAccountNo(Long accNo, String txnType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TransactionRecord> getTransactionRecordsByAccountNo(Long accNo, LocalDate fromDate, LocalDate toDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TransactionRecord> getTransactionRecordsByRefNo(String refNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TransactionRecord> getTransactionRecordsByStatus(String status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TransactionRecord getTransactionRecord(Long txnNo) {
		// TODO Auto-generated method stub
		return null;
	}

}
