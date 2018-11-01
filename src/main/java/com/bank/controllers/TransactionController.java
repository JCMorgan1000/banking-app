package com.bank.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.entities.Account;
import com.bank.entities.Transaction;
import com.bank.rest.NewTransactionReq;
import com.bank.services.TransactionService;
import com.bank.views.Views;
import com.fasterxml.jackson.annotation.JsonView;

@RestController
@RequestMapping("transactions")
@CrossOrigin()
public class TransactionController {
	@Autowired
	private TransactionService ts;
	
	@GetMapping("all/{act}")
	@JsonView(Views.Wide.class)
	public ResponseEntity<List<Transaction>> getAllTransactions(@PathVariable Account act) {
		try {
			return new ResponseEntity<List<Transaction>>(ts.getAll(act), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<List<Transaction>>(HttpStatus.UNAUTHORIZED);
		}
	}
	
	@PostMapping("new")
	@JsonView(Views.Wide.class)
	public ResponseEntity<Account> newTransaction(@RequestBody NewTransactionReq tr) {
		try {
			return new ResponseEntity<Account>(ts.newTransaction(tr), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Account>(HttpStatus.UNAUTHORIZED);
		}
	}
}
