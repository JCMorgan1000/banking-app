package com.bank.rest;

import com.bank.entities.Account;
import com.bank.entities.User;

public class AccountUserReq {
	
	private User user;
	private Account act;
	
	public AccountUserReq() {
	}

	public AccountUserReq(User user, Account act) {
		super();
		this.user = user;
		this.act = act;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Account getAct() {
		return act;
	}

	public void setAct(Account act) {
		this.act = act;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((act == null) ? 0 : act.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		AccountUserReq other = (AccountUserReq) obj;
		if (act == null) {
			if (other.act != null)
				return false;
		} else if (!act.equals(other.act))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "NewAccountRequest [user=" + user + ", act=" + act + "]";
	}
}
