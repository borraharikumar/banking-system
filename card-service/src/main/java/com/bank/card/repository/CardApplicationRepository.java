package com.bank.card.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bank.card.entity.CardApplication;

public interface CardApplicationRepository extends JpaRepository<CardApplication, Integer> {
	
	@Query("UPDATE CardApplication SET status=:status WHERE applicationNo=:applicationNo")
	public void updateCardApplicationStatus(Integer applicationNo, String status);
	
	@Query("SELECT ca FROM CardApplication ca WHERE ca.status='APPLIED'")
	public List<CardApplication> getCardApplications();
	
	@Query("SELECT ca FROM CardApplication ca WHERE ca.status=:status")
	public List<CardApplication> getCardApplicationsByStatus(String status);
	
	@Query("SELECT ca FROM CardApplication ca WHERE ca.accountNo=:accNo")
	public List<CardApplication> getCardApplicationsByAccountNo(Long accNo);
	
	@Query("SELECT ca FROM CardApplication ca WHERE ca.applicationDate=:applicationDate")
	public List<CardApplication> getCardApplicationsByApplicatioDate(LocalDate applicationDate);
	
	@Query("SELECT ca FROM CardApplication ca WHERE ca.applicationDate BETWEEN :fromDate AND :toDate")
	public List<CardApplication> getCardApplicationsByApplicatioDate(LocalDate fromDate, LocalDate toDate);

}
