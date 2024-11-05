package com.bank.account.service;

import com.bank.account.dto.AccountDto;
import com.bank.account.dto.MoneyDepositRequest;
import com.bank.account.dto.MoneyDepositResponse;
import com.bank.account.dto.MoneyTransferRequest;
import com.bank.account.dto.MoneyTransferResponse;
import com.bank.account.dto.MoneyWithdrawRequest;
import com.bank.account.dto.MoneyWithdrawResponse;

public interface IAccountService {
	
	public AccountDto createAccount(AccountDto dto);
	public AccountDto getAccount(Long accNo);
	public MoneyDepositResponse moneyDeposit(MoneyDepositRequest depositRequest);
	public MoneyWithdrawResponse moneyWithdraw(MoneyWithdrawRequest withdrawRequest);
	public MoneyTransferResponse moneyTransfer(MoneyTransferRequest transferRequest);
	public AccountDto closeAccount(Long accNo);
	
	public String getPassword(Long accNo);

}
