package com.bank.card.service;

import java.time.LocalDate;
import java.util.List;

import com.bank.card.entity.CardApplication;

public interface ICardApplicationService {

	public Integer insertCardApplication(CardApplication application);
	public CardApplication getCardApplication(Integer applicationNo);
	public List<CardApplication> getCardApplications();
	public String updateCardApplicationStatus(Integer applicationNo, String status);
	public List<CardApplication> getCardApplicationsByStatus(String status);
	public List<CardApplication> getCardApplicationsByAccountNo(Long accNo);
	public List<CardApplication> getCardApplicationsByApplicatioDate(LocalDate applicationDate);
	public List<CardApplication> getCardApplicationsByApplicatioDate(LocalDate fromDate, LocalDate toDate);

}
