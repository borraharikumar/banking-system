package com.bank.card.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.card.entity.Card;
import com.bank.card.exception.CardNotFoundException;
import com.bank.card.repository.CardRepository;

@Service
public class CardServiceImpl implements ICardService {
	
	@Autowired private CardRepository cardRepository;

	@Override
	public Long insertCard(Card card) {
		return cardRepository.save(card).getCardNo();
	}

	@Override
	public Card getCard(Long cardNo) {
		return cardRepository.findById(cardNo)
					.orElseThrow(()->new CardNotFoundException("Card details not found with card number '" + cardNo + "'"));
	}

	@Override
	public String updateCardStatus(Long cardNo, String status) {
		cardRepository.updateCardStatus(cardNo, status);
		return "Card status with card number '" + cardNo + "' is updated to '" + status + "'";
	}

	@Override
	public List<Card> getAccountLinkedCards(Long accNo) {
		return cardRepository.findCardsByAccountNo(accNo);
	}

}
