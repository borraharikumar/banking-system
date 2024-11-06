package com.bank.card.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.card.entity.CardApplication;
import com.bank.card.exception.CardApplicationNotFoundException;
import com.bank.card.repository.CardApplicationRepository;

@Service
public class CardApplicationServiceImpl implements ICardApplicationService {
	
	@Autowired private CardApplicationRepository applicationRepository;

	@Override
	public Integer insertCardApplication(CardApplication application) {
		application.setApplicationDate(LocalDate.now());
		return applicationRepository.save(application).getApplicationNo();
	}
	
	@Override
	public CardApplication getCardApplication(Integer applicationNo) {
		return applicationRepository.findById(applicationNo)
			.orElseThrow(()->new CardApplicationNotFoundException("Application not found with id '" + applicationNo + "'"));
	}
	
	@Override
	public List<CardApplication> getCardApplications() {
		return applicationRepository.getCardApplications();
	}

	@Override
	public String updateCardApplicationStatus(Integer applicationNo, String status) {
		applicationRepository.updateCardApplicationStatus(applicationNo, status);
		return "Application status of card application '" + applicationNo + "' is changed to '" + status + "'";
	}

	@Override
	public List<CardApplication> getCardApplicationsByStatus(String status) {
		return applicationRepository.getCardApplicationsByStatus(status);
	}

	@Override
	public List<CardApplication> getCardApplicationsByAccountNo(Long accNo) {
		return applicationRepository.getCardApplicationsByAccountNo(accNo);
	}

	@Override
	public List<CardApplication> getCardApplicationsByApplicatioDate(LocalDate applicationDate) {
		return applicationRepository.getCardApplicationsByApplicatioDate(applicationDate);
	}

	@Override
	public List<CardApplication> getCardApplicationsByApplicatioDate(LocalDate fromDate, LocalDate toDate) {
		return applicationRepository.getCardApplicationsByApplicatioDate(fromDate, toDate);
	}

}
