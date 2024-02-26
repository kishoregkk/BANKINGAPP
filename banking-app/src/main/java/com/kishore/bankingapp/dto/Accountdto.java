package com.kishore.bankingapp.dto;

import org.springframework.stereotype.Component;

public class Accountdto {
	
	private int id;
	private String accountHolderName;
	private double balance;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAccountHolderName() {
		return accountHolderName;
	}
	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public Accountdto(int id, String accountHolderName, double balance) {
		super();
		this.id=id;
		this.accountHolderName = accountHolderName;
		this.balance = balance;
	}
	
	public Accountdto()
	{
		
	}


}
