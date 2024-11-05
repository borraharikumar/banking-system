package com.bank.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bank.customer.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
	//@Query("SELECT COUNT(*) FROM Customer c JOIN c.loginCredentials lc WHERE c.customerId=:custId AND lc.password=:password")
	//public String getCountOfCustomers(Long custId, String password);
	
	@Query("SELECT lc.password FROM Customer c JOIN c.loginCredentials lc WHERE c.customerId=:custId")
	public String getCountOfCustomers(Long custId);

}
