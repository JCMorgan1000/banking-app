package com.bank.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.bank.views.Views;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name="ACCOUNT")
public class Account {
	@Id
	@Column(name="ACCOUNT_ID", updatable = false, nullable = false)
	@SequenceGenerator(name="AID_SEQ", sequenceName="AID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="AID_SEQ")
	@JsonView(Views.Select.class)
	private int accountId;
	@Column(name="ACCOUNT_TYPE")
	@JsonView(Views.Select.class)
	private int accountType;
	@Column(name="ACCOUNT_BALANCE")
	@JsonView(Views.Select.class)
	private double accountBalance;
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
	        name = "USERS_ACCOUNTS", 
	        joinColumns = { @JoinColumn(name = "account_id") }, 
	        inverseJoinColumns = { @JoinColumn(name = "user_id") }
	    )
	@JsonView(Views.Select.class)
	List<User> users = new ArrayList<>();
	@OneToMany(mappedBy = "account", cascade=CascadeType.MERGE)
	List<Transaction> transactions = new ArrayList<>();

	public Account() {
	}

	public Account(int accountId, int accountType, double accountBalance, List<User> users,
			List<Transaction> transactions) {
		this.accountId = accountId;
		this.accountType = accountType;
		this.accountBalance = accountBalance;
		this.users = users;
		this.transactions = transactions;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public int getAccountType() {
		return accountType;
	}

	public void setAccountType(int accountType) {
		this.accountType = accountType;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(accountBalance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = (prime * result + accountId);
		result = prime * result + accountType;
		result = prime * result + ((transactions == null) ? 0 : transactions.hashCode());
		result = prime * result + ((users == null) ? 0 : users.hashCode());
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
		Account other = (Account) obj;
		if (Double.doubleToLongBits(accountBalance) != Double.doubleToLongBits(other.accountBalance))
			return false;
		if (accountId != other.accountId)
			return false;
		if (accountType != other.accountType)
			return false;
		if (transactions == null) {
			if (other.transactions != null)
				return false;
		} else if (!transactions.equals(other.transactions))
			return false;
		if (users == null) {
			if (other.users != null)
				return false;
		} else if (!users.equals(other.users))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", accountType=" + accountType + ", accountBalance=" + accountBalance
				+ ", users=" + users + ", transactions=" + transactions + "]";
	}

}
