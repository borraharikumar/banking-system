package com.bank.account.dto;

import lombok.Data;

@Data
public class MoneyTransferResponse {
	
	private Long hostAccountNo;
	private Long beneAccountNo;
	private Double txnAmount;
	private String status;
	private Long hostAccountTxnNumber;
	private Long beneAccountTxnNumber;
	private String refNumber;

}
