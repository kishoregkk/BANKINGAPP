package com.kishore.bankingapp.controller;

import java.util.List;
import java.util.Map;

import org.hibernate.boot.model.naming.ImplicitNameSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.kishore.bankingapp.dto.Accountdto;
import com.kishore.bankingapp.mapper.AccountMapper;
import com.kishore.bankingapp.service.AccountService;

@RestController
@RequestMapping("/bank")
public class AccountController {
	
	AccountService accountService;
	
	public AccountController(AccountService accountService)
	{
		this.accountService=accountService;
	}
	
	@PostMapping("/create")
	public ResponseEntity<Accountdto> createtheaccount(@RequestBody Accountdto accountdto) 
	{
		return new ResponseEntity<>
		( accountService.createAccount(accountdto),HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Accountdto> findTheAccountById(@PathVariable int id)
	{
			Accountdto accountdto=accountService.getAccountByid(id);
			return  ResponseEntity.ok(accountdto);
	}
	
	@PutMapping("/deposit/{id}")
	public ResponseEntity<Accountdto> deposithEntityAccounttt
	(@PathVariable int id, @RequestBody Map<String, Double> request)
	{
		double amount=request.get("amountkey");
		return ResponseEntity.ok(accountService.depositAmount(id, amount));		
	}
	
	
	@PutMapping("/withdraw/{id}")
	public ResponseEntity<Accountdto> withdraw(@PathVariable int id,
			@RequestBody Map<String,Double> req)
	{
		return ResponseEntity
				.ok(accountService.withdrawtheAmount(id,req.get("withrs")));
	
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Accountdto>>getAllAccounts()
	{
		return  ResponseEntity.ok(accountService.getAlltheAccount());
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteAccount(@PathVariable int id)
	{
	return ResponseEntity.ok("Account is deleteed successfully");	
	}
	
	

}
