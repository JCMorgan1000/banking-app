package com.bank.rest;

import com.bank.entities.Account;

public class NewTransactionReq {

	private Account account;
	private double amount;
	private int type;
	
	public NewTransactionReq() {
	}

	public NewTransactionReq(Account account, double amount, int type) {
		super();
		this.account = account;
		this.amount = amount;
		this.type = type;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

}
