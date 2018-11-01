package com.bank.services;

import java.util.List;

import com.bank.entities.Account;
import com.bank.entities.Transaction;
import com.bank.rest.NewTransactionReq;

public interface TransactionService {
	
	List<Transaction> getAll(Account act);
	Account newTransaction(NewTransactionReq tx);
}
