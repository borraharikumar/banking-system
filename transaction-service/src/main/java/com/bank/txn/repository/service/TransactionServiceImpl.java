package com.bank.txn.repository.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.txn.entity.TransactionRecord;
import com.bank.txn.repository.TransactionRepository;
import com.bank.txn.repository.exception.TxnNotFoundException;

@Service
public class TransactionServiceImpl implements ITransactionService {
	
	@Autowired private TransactionRepository txnRepository;

	@Override
	public String saveTransactionRecord(TransactionRecord txnRecord) {
		return txnRepository.save(txnRecord).getTxnId();
	}

	@Override
	public List<TransactionRecord> getTransactionRecordsByAccountNo(Long accNo) {
		return txnRepository.getAccountTransactions(accNo);
	}

	@Override
	public List<TransactionRecord> getTransactionRecordsByAccountNo(Long accNo, String txnType) {
		return txnRepository.getAccountTransactions(accNo, txnType);
	}

	@Override
	public List<TransactionRecord> getTransactionRecordsByAccountNo(Long accNo, LocalDateTime fromDate, LocalDateTime toDate) {
		return txnRepository.getAccountTransactions(accNo, fromDate, toDate);
	}

	@Override
	public List<TransactionRecord> getTransactionRecordsByRefNo(String refNo) {
		return txnRepository.getTransactionRecordsByRefNo(refNo);
	}

	@Override
	public List<TransactionRecord> getTransactionRecordsByStatus(Long accNo, String status) {
		return txnRepository.getTransactionRecordsByStatus(accNo, status);
	}

	@Override
	public TransactionRecord getTransactionRecord(String txnNo) {
		return txnRepository.findById(txnNo)
					.orElseThrow(()->new TxnNotFoundException("Transaction not found with txn_id '" + txnNo + "'"));
	}

}
