package com.bank.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.entities.Account;
import com.bank.rest.AccountUserReq;
import com.bank.services.AccountService;

@RestController
@RequestMapping("accounts")
@CrossOrigin()
public class AccountController {
	@Autowired
	private AccountService as;
	
	@PostMapping("new")
	public ResponseEntity<Account> openAccount(@RequestBody AccountUserReq na) {
		try {
			return new ResponseEntity<Account>(as.openAccount(na.getUser() , na.getAct()), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Account>(HttpStatus.UNAUTHORIZED);
		}
	}
}
