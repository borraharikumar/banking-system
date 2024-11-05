package com.bank.txn.entity;

import java.time.LocalDateTime;
import java.util.Random;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "transactions_tab")
public class TransactionRecord {
	
	@Id
	private String txnId;
	private Long accountNo;
	private Double amount;
	private String txnType;
	private LocalDateTime timestamp;
	private String txnMode;
	private String status;
	private String refNumber;
	
	@PrePersist
	public void generateTxnId() {
		if(txnId==null) {
			LocalDateTime timestamp = LocalDateTime.now();
			Integer year = timestamp.getYear();
			Integer month = timestamp.getMonthValue();
			Integer date = timestamp.getDayOfMonth();
			Integer hour = timestamp.getHour();
			Integer minute = timestamp.getMinute();
			Integer second = timestamp.getSecond();
			Integer milli = timestamp.getNano();
			Integer random = new Random().nextInt(10, 99);
			txnId = "TXN"+year+""+month+""+date+""+hour+""+minute+""+second+""+milli+""+random;
		}
	}

}
