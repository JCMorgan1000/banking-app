package com.bank.entities;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.bank.views.Views;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name="TRANSACTIONS")
public class Transaction {
	@Id
	@Column(name="TRANSACTION_ID", updatable = false, nullable = false)
	@SequenceGenerator(name="TRANSID_SEQ", sequenceName="TRANSID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TRANSID_SEQ")
	@JsonView(Views.Wide.class)
	private int transactionId;
	@JsonView(Views.Wide.class)
	private double amount;
	@JsonView(Views.Wide.class)
	private int type;
	@Column(name="DATE_TIME")
	@JsonView(Views.Wide.class)
	private Timestamp dateTime;
	@ManyToOne()
	@JoinColumn(name="ACCOUNT_ID")
	private Account account;
	
	public Transaction() {
	}

	public Transaction(int transactionId, double amount, int type, Timestamp dateTime, Account account) {
		super();
		this.transactionId = transactionId;
		this.amount = amount;
		this.type = type;
		this.dateTime = dateTime;
		this.account = account;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
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

	public Timestamp getDateTime() {
		return dateTime;
	}

	public void setDateTime(Timestamp timestamp) {
		this.dateTime = timestamp;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((account == null) ? 0 : account.hashCode());
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((dateTime == null) ? 0 : dateTime.hashCode());
		result = (prime * result + transactionId);
		result = prime * result + type;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transaction other = (Transaction) obj;
		if (account == null) {
			if (other.account != null)
				return false;
		} else if (!account.equals(other.account))
			return false;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (dateTime == null) {
			if (other.dateTime != null)
				return false;
		} else if (!dateTime.equals(other.dateTime))
			return false;
		if (transactionId != other.transactionId)
			return false;
		if (type != other.type)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", amount=" + amount + ", type=" + type + ", dateTime="
				+ dateTime + ", account=" + account + "]";
	}
}
