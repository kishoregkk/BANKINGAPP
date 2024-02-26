package com.kishore.bankingapp.service.impl;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.management.RuntimeErrorException;

import org.apache.el.parser.AstGreaterThanEqual;
import org.springframework.stereotype.Service;
import com.kishore.bankingapp.Repository.AccountRepository;
import com.kishore.bankingapp.dto.Accountdto;
import com.kishore.bankingapp.entity.Account;
import com.kishore.bankingapp.mapper.AccountMapper;
import com.kishore.bankingapp.service.AccountService;

@Service
public class AccountServiceImplementation implements AccountService {

   AccountRepository accountRepository;
	
	public AccountServiceImplementation(AccountRepository accountRepository)
	{
		this.accountRepository=accountRepository;
	}
	
	@Override
	public Accountdto createAccount(Accountdto accountdto) {
	       
		Account account=AccountMapper.accountdtoToAccount(accountdto);
		Account account2=accountRepository.save(account);
		return AccountMapper.accounttoAccountDto(account2);
	}

	@Override
	public Accountdto getAccountByid(int id) {
		
		Account account=accountRepository.findById(id)
				.orElseThrow(()-> new RuntimeException("give valid id"));
		Accountdto accountdto=AccountMapper.accounttoAccountDto(account);
		return accountdto;

	}

	@Override
	public Accountdto depositAmount(int id,double amount) {
		 Account account=accountRepository
				 .findById(id).
				 orElseThrow(()-> new RuntimeException("give valid id "));
		 double total= account.getBalance()+amount;
		 account.setBalance(total);
		 accountRepository.save(account);
		 return AccountMapper.accounttoAccountDto(account);
		 
	}

	@Override
	public Accountdto withdrawtheAmount(int id, double amount) {
		Account account=accountRepository.findById(id)
				.orElseThrow(()->new RuntimeException("give valid id"));
		if(account.getBalance()<amount)
		{
			throw new RuntimeException("reqesting amount greater than your balance");
		}
		Double afterwithdraw=account.getBalance()-amount;
		account.setBalance(afterwithdraw);
		accountRepository.save(account);
		return AccountMapper.accounttoAccountDto(account);
	}

	@Override
	public List<Accountdto> getAlltheAccount() {
			List<Account> accounts=accountRepository.findAll();
			return  accounts.stream()
					.map((account)->AccountMapper.accounttoAccountDto(account))
					.collect(Collectors.toList());
	}

	@Override
	public Accountdto deteleTheAccounttt(int id) {
		Account account=accountRepository.findById(id)
				.orElseThrow(()-> new RuntimeException("give valid id"));
		Accountdto accountdto=AccountMapper.accounttoAccountDto(account);
		accountRepository.delete(account);
		return accountdto;
	}

}
