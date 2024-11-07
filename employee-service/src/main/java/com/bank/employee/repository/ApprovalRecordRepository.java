package com.bank.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bank.employee.entity.ApprovalRecord;

public interface ApprovalRecordRepository extends JpaRepository<ApprovalRecord, Integer> {
	
	@Query("SELECT ar FROM ApprovalRecord ar WHERE ar.employeeId=:empId")
	public List<ApprovalRecord> getEmployeeApprovalRecords(Integer empId);

}
