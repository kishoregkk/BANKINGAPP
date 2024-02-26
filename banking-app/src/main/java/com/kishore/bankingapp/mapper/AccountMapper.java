package com.kishore.bankingapp.mapper;
import com.kishore.bankingapp.dto.Accountdto;
import com.kishore.bankingapp.entity.Account;

public class AccountMapper {
	
	public static  Account accountdtoToAccount(Accountdto accountdto)
	{
		Account account=new  Account(accountdto.getId(),
				accountdto.getAccountHolderName(),accountdto.getBalance());
		return account;
	}
	
	public static  Accountdto accounttoAccountDto(Account account)
	{
		Accountdto accountdto=new Accountdto(account.getId(),
				account.getAccountHolderName(),account.getBalance());
		return accountdto;
	}
	

}
