package com.bank.card.entity;

import java.time.LocalDate;
import java.util.Random;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "cards_tab")
public class Card {
	
	@Id
	private Long cardNo;
	private Long accountNo;
	private String cardType;		// CREDIT/DEBIT
	private String expiryDate;
	private Integer cvv;
	private String status;			// ISSUED/ACTIVE/DEACTIVE/BLOCKED
	private LocalDate issuedDate;
	private LocalDate activationDate;
	
	@PrePersist
	public void card() {
		if(cardNo==null) {
			Random random = new Random();
			//Generating Card number
			Integer first  = random.nextInt(1000, 9999);
			Integer second = random.nextInt(1000, 9999);
			Integer third  = random.nextInt(1000, 9999);
			Integer fourth = random.nextInt(1000, 9999);
			cardNo = Long.parseLong(first+""+second+""+third+""+fourth);
			//Issued date
			issuedDate = LocalDate.now();
			//CVV
			cvv = random.nextInt(100, 999);
			//Expiry date
			expiryDate = issuedDate.getMonthValue() + "/" + (issuedDate.getYear()+5);
			//Status
			status = "ISSUED";
		}
	}

}
