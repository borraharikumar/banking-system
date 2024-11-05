package com.bank.account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.account.dto.AccountDto;
import com.bank.account.dto.MoneyDepositRequest;
import com.bank.account.dto.MoneyDepositResponse;
import com.bank.account.dto.MoneyTransferRequest;
import com.bank.account.dto.MoneyTransferResponse;
import com.bank.account.dto.MoneyWithdrawRequest;
import com.bank.account.dto.MoneyWithdrawResponse;
import com.bank.account.exception.AccountNotFoundException;
import com.bank.account.exception.InsufficientBalanceException;
import com.bank.account.mapper.AccountMapper;
import com.bank.account.repository.AccountRepository;

@Service
public class AccountServiceImpl implements IAccountService {
	
	@Autowired private AccountRepository accountRepository;
	@Autowired private AccountMapper accountMapper;
	
	@Override
	public AccountDto createAccount(AccountDto dto) {
		return accountMapper.mapToAccountDto(accountRepository.save(accountMapper.mapToAccount(dto)));
	}

	@Override
	public AccountDto getAccount(Long accNo) {
		return accountMapper.mapToAccountDto(
					accountRepository.findById(accNo)
						.orElseThrow(()->new AccountNotFoundException("Account not found with no '" + accNo + "'"))
			   );
	}

	@Override
	public MoneyDepositResponse moneyDeposit(MoneyDepositRequest depositRequest) {
		AccountDto dto = getAccount(depositRequest.getAccountNo());
		
		MoneyDepositResponse depositResponse = new MoneyDepositResponse();
		depositResponse.setAccountNo(depositRequest.getAccountNo());
		depositResponse.setPreviousBalance(dto.getBalance());
		
		dto.setBalance(dto.getBalance()+depositRequest.getAmount());
		
		depositResponse.setCreditedAmount(depositRequest.getAmount());
		depositResponse.setCurrentBalance(createAccount(dto).getBalance());
		depositResponse.setDepositedBy(depositRequest.getDepositedBy());
		depositResponse.setStatus("SUCCESS");
		return depositResponse;
	}

	@Override
	public MoneyWithdrawResponse moneyWithdraw(MoneyWithdrawRequest withdrawRequest) {
		AccountDto dto = getAccount(withdrawRequest.getAccountNo());
		
		MoneyWithdrawResponse withdrawResponse = new MoneyWithdrawResponse();
		withdrawResponse.setAccountNo(dto.getAccountNo());
		withdrawResponse.setPreviousBalance(dto.getBalance());
		
		if(dto.getBalance()>withdrawRequest.getAmount())
			dto.setBalance(dto.getBalance()-withdrawRequest.getAmount());
		else
			throw new InsufficientBalanceException("Insufficient balance...!");
		
		withdrawResponse.setDebitedAmount(withdrawRequest.getAmount());
		withdrawResponse.setCurrentBalance(createAccount(dto).getBalance());
		withdrawResponse.setStatus("SUCCESS");
		return withdrawResponse;
	}
	
	@Override
	public MoneyTransferResponse moneyTransfer(MoneyTransferRequest transferRequest) {
		MoneyWithdrawRequest withdrawRequest = new MoneyWithdrawRequest();
		withdrawRequest.setAccountNo(transferRequest.getHostAccountNo());
		withdrawRequest.setTxnPassword(transferRequest.getTxnPassword());
		withdrawRequest.setAmount(transferRequest.getAmount());
		moneyWithdraw(withdrawRequest);
		
		MoneyDepositRequest depositRequest = new MoneyDepositRequest();
		depositRequest.setAccountNo(transferRequest.getBeneAccountNo());
		depositRequest.setAmount(transferRequest.getAmount());
		depositRequest.setDepositedBy(transferRequest.getHostAccountNo().toString());
		
		MoneyTransferResponse transferResponse = new MoneyTransferResponse();
		transferResponse.setHostAccountNo(transferRequest.getHostAccountNo());
		transferResponse.setBeneAccountNo(transferRequest.getBeneAccountNo());
		transferResponse.setTxnAmount(transferRequest.getAmount());
		transferResponse.setStatus("SUCCESS");
		
		return transferResponse;
	}

	@Override
	public AccountDto closeAccount(Long accNo) {
		AccountDto dto = getAccount(accNo);
		dto.setStatus("CLOSED");
		return createAccount(dto);
	}

	@Override
	public String getPassword(Long accNo) {
		return accountRepository.getTxnPassword(accNo);
	}

}
