package com.bank.repos;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.entities.Account;
import com.bank.entities.User;

public interface AccountRepo extends JpaRepository<Account, Integer> {
	Set<Account> findAllByUsers(User u);
}
