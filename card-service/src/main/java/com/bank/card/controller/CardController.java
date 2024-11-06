package com.bank.card.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.card.entity.Card;
import com.bank.card.service.ICardService;

@RestController
@RequestMapping("/card")
public class CardController {
	
	@Autowired private ICardService cardService;
	
	@PostMapping
	public ResponseEntity<Long> approveCard(@RequestBody Card card) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
							 .body(cardService.insertCard(card));
	}
	
	@GetMapping
	public ResponseEntity<Card> getCard(@PathVariable Long cardNo) {
		return ResponseEntity.ok(cardService.getCard(cardNo));
	}
	
	@PutMapping("/{cardNo}/{status}")
	public ResponseEntity<String> updateCardStatus(@PathVariable Long cardNo, @PathVariable String status) {
		return ResponseEntity.ok(cardService.updateCardStatus(cardNo, status));
	}
	
	@GetMapping("/{accNo}")
	public ResponseEntity<List<Card>> getAccountLinkedCards(@PathVariable Long accNo) {
		return ResponseEntity.ok(cardService.getAccountLinkedCards(accNo));
	}

}
