package com.bank.account.mapper;

import org.springframework.stereotype.Component;

import com.bank.account.dto.AccountDto;
import com.bank.account.entity.Account;

@Component
public class AccountMapper {
	
	public Account mapToAccount(AccountDto dto) {
		Account account = new Account();
		if(dto.getAccountNo()!=null)
			account.setAccountNo(dto.getAccountNo());
		account.setCustomerId(dto.getCustomerId());
		account.setAccountType(dto.getAccountType());
		account.setBalance(dto.getBalance());
		account.setCreatedDate(dto.getCreatedDate());
		account.setLastTxnDate(dto.getLastTxnDate());
		account.setStatus(dto.getStatus());
		account.setTxnPassword(dto.getTxnPassword());
		return account;
	}
	
	public AccountDto mapToAccountDto(Account account) {
		AccountDto dto = new AccountDto();
		dto.setAccountNo(account.getAccountNo());
		dto.setCustomerId(account.getCustomerId());
		dto.setAccountType(account.getAccountType());
		dto.setBalance(account.getBalance());
		dto.setCreatedDate(account.getCreatedDate());
		dto.setLastTxnDate(account.getLastTxnDate());
		dto.setStatus(account.getStatus());
		dto.setTxnPassword(account.getTxnPassword());
		return dto;
	}

}
