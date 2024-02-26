package com.kishore.bankingapp.service;

import java.util.List;

import com.kishore.bankingapp.dto.Accountdto;

public interface AccountService {
	
	Accountdto createAccount(Accountdto accountdto);
	
	Accountdto getAccountByid(int id);
	
	Accountdto depositAmount(int id,double amount);
	
	Accountdto withdrawtheAmount(int id,double amount);
	
	List<Accountdto> getAlltheAccount();
	
	Accountdto deteleTheAccounttt(int id);

}
