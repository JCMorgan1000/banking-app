package com.bank.services;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.entities.Account;
import com.bank.entities.User;
import com.bank.repos.AccountRepo;
import com.bank.repos.UserRepo;

@Service
public class UserServiceImpl implements UserService {
	private static final Logger log = Logger.getLogger(UserService.class);
	
	@Autowired
	private UserRepo ur;
	@Autowired
	private AccountRepo ar;

	@Override
	public User createNew(User u) {
		log.info("Creating new user");
		u.setUserId(0);
		u.setUsername(u.getUsername());
		u.setPassword(u.getPassword());
		u.setFirstName(u.getFirstName());
		u.setLastName(u.getLastName());
		u.setEmailAddress(u.getEmailAddress());
		return ur.save(u);
	}
	
	@Override
	public Account addUser(User user, Account act) {
		log.info("Adding " + user.getFirstName() + " to account#: " + act.getAccountId());
		act.setAccountId(act.getAccountId());
		act.setAccountType(act.getAccountType());
		act.setAccountBalance(act.getAccountBalance());
		List<User> users = act.getUsers();
		users.add(user);
		act.setUsers(users);
		return ar.save(act);
	}

	@Override
	public User login(String username, String password) {
		log.info("Finding user by username");
		User u = ur.findByUsername(username);
		log.debug("Validating the credentials of user#: " + u.getUserId());
		if (password.equals(u.getPassword())) {
			return u;
		} else {
			return null;
		}
	}
	
	@Override
	public User logout(String username) {
		
		return null;
	}

	@Override
	public List<Account> findAccounts(int id) {
		User user = ur.findByUserId(id);
		List<Account> accounts = user.getAccounts();
		return accounts;
	}

	@Override
	public User findByUsername(String username) {
		return ur.findByUsername(username);
	}

	@Override
	public User findByUserId(int id) {
		return ur.findByUserId(id);
	}

}
