package com.bank.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bank.entities.User;

public interface UserRepo extends JpaRepository<User, Integer> {
	
	User findByUsername(String username);
	User findByUserId(int id);
}
