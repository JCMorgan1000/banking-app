package com.bank.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.entities.Account;
import com.bank.entities.User;
import com.bank.repos.AccountRepo;

@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	private AccountRepo ar;

	@Override
	public Account openAccount(User user, Account act) {
		act.setAccountId(0);
		act.setAccountType(act.getAccountType());
		act.setAccountBalance(act.getAccountBalance());
		List<User> users = act.getUsers();
		users.add(user);
		act.setUsers(users);
		return ar.save(act);
	}
	
}
