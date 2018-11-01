package com.bank.controllers;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.entities.Account;
import com.bank.entities.User;
import com.bank.rest.AccountUserReq;
import com.bank.services.UserService;
import com.bank.views.Views;
import com.fasterxml.jackson.annotation.JsonView;

@RestController
@RequestMapping("users")
@CrossOrigin()
public class UserController {
	private static final Logger log = Logger.getLogger(UserController.class);
	
	@Autowired
	private UserService us;
	
	@PostMapping("login")
	@JsonView(Views.Select.class)
	public ResponseEntity<User> login(@RequestBody User u) {
		try {
			log.debug("Calling login service for " + u.getUsername());
			return new ResponseEntity<User>(us.login(u.getUsername(), u.getPassword()), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<User>(HttpStatus.UNAUTHORIZED);
		}
	}
	
	@PostMapping("logout")
	@JsonView(Views.Select.class)
	public ResponseEntity<User> logout(@RequestBody User u) {
		try {
			return new ResponseEntity<User>(us.logout(u.getUsername()), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<User>(HttpStatus.UNAUTHORIZED);
		}
	}
	
	@PostMapping("new")
	@JsonView(Views.Select.class)
	public ResponseEntity<User> createNew(@RequestBody User u) {
		try {
			log.info("Calling createNew service for " + u.getFirstName());
			return new ResponseEntity<User>(us.createNew(u), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<User>(HttpStatus.UNAUTHORIZED);
		}
	}
	
	@PostMapping("add")
	@JsonView(Views.Select.class)
	public ResponseEntity<Account> addUser(@RequestBody AccountUserReq req) {
		try {
			return new ResponseEntity<Account>(us.addUser(req.getUser(), req.getAct()), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Account>(HttpStatus.UNAUTHORIZED);
		}
	}
	
	@GetMapping("find/{username}")
	@JsonView(Views.Select.class)
	public ResponseEntity<User> findByUsername(@PathVariable String username) {
		try {
			return new ResponseEntity<User>(us.findByUsername(username), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<User>(HttpStatus.UNAUTHORIZED);
		}
	}
	
	@GetMapping("find/{id}")
	@JsonView(Views.Select.class)
	public ResponseEntity<User> findByUserId(@PathVariable int id) {
		try {
			return new ResponseEntity<User>(us.findByUserId(id), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<User>(HttpStatus.UNAUTHORIZED);
		}
	}
	
	@GetMapping("accounts/{id}")
	@JsonView(Views.Select.class)
	public ResponseEntity<List<Account>> findAccounts(@PathVariable int id) {
		try {
			return new ResponseEntity<List<Account>>(us.findAccounts(id), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<List<Account>>(HttpStatus.UNAUTHORIZED);
		}
	}
	
}
