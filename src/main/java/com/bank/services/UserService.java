package com.bank.services;

import java.util.List;

import com.bank.entities.Account;
import com.bank.entities.User;

public interface UserService {
	
	User createNew(User user);
	Account addUser(User user, Account act);
	User login(String username, String password);
	User logout(String username);
	User findByUsername(String username);
	User findByUserId(int id);
	List<Account> findAccounts(int id);
}
