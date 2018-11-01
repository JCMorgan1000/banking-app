package com.bank.services;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.entities.Account;
import com.bank.entities.Transaction;
import com.bank.repos.AccountRepo;
import com.bank.repos.TransactionRepo;
import com.bank.rest.NewTransactionReq;

@Service
public class TransactionServiceImpl implements TransactionService {
	@Autowired
	private TransactionRepo tr;
	@Autowired
	private AccountRepo ar;

	@Override
	public List<Transaction> getAll(Account act) {
		if(act.getTransactions().size() < 1)
			return null;
		return tr.findByAccount(act);
	}
	
	@Override
	public Account newTransaction(NewTransactionReq txR) {
		Account act = txR.getAccount();
		//calculate new balance
		double newBal = 0, bal = act.getAccountBalance();
		if(txR.getType() == 1) {
			newBal = (bal + txR.getAmount());
		} else if(txR.getType() == 2) {
			newBal = (bal - txR.getAmount());
		} 
		//update account
		act.setAccountId(act.getAccountId());
		act.setAccountType(act.getAccountType());
		act.setAccountBalance(newBal);
		act.setUsers(act.getUsers());
		
		//new transaction
		Transaction tx = new Transaction();
		tx.setTransactionId(0);
		tx.setAccount(act);
		tx.setAmount(txR.getAmount());
		tx.setType(txR.getType());
		tx.setDateTime(new Timestamp(System.currentTimeMillis()));
		List<Transaction> transactions = act.getTransactions();
		transactions.add(tx);
		act.setTransactions(transactions);
		return ar.save(act);
	}

}
