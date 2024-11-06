package com.bank.card.service;

import java.util.List;

import com.bank.card.entity.Card;

public interface ICardService {

	public Long insertCard(Card card);
	public Card getCard(Long cardNo);
	public String updateCardStatus(Long cardNo, String status);
	public List<Card> getAccountLinkedCards(Long accNo);

}
