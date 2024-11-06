package com.bank.card.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bank.card.entity.Card;

public interface CardRepository extends JpaRepository<Card, Long> {
	
	@Query("UPDATE Card SET status=:status WHERE accountNo=:accNo")
	public void updateCardStatus(Long accNo, String status);
	
	@Query("SELECT c FROM Card c WHERE c.accountNo=:accNo")
	public List<Card> findCardsByAccountNo(Long accNo);

}
