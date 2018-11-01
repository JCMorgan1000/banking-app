package com.bank.repos;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.bank.entities.Account;
import com.bank.entities.Transaction;

public interface TransactionRepo extends JpaRepository<Transaction, Integer> {
	
	List<Transaction> findByAccount(Account act);
}
