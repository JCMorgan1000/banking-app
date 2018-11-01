package com.bank.services;

import com.bank.entities.Account;
import com.bank.entities.User;

public interface AccountService {
	Account openAccount(User user, Account act);
}
