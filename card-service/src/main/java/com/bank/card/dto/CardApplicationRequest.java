package com.bank.card.dto;

import com.bank.card.entity.CardApplication;

import lombok.Data;

@Data
public class CardApplicationRequest {
	
	private CardApplication cardApplication;
	private String txnPassword;

}
