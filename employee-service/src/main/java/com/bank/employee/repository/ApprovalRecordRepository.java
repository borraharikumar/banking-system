package com.bank.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.employee.entity.ApprovalRecord;

public interface ApprovalRecordRepository extends JpaRepository<ApprovalRecord, Integer> {

}
