package com.jcmorgan.test;

import org.apache.log4j.Logger;
import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;

import com.bank.entities.User;

public class TestUserService extends ApplicationTests {
	
	
	@Autowired
	private TestRestTemplate restTemplate;
	private static final Logger log = Logger.getLogger(TestUserService.class);
	private User user;
	
	@Before
	public void setup() throws JSONException {
		user = new User();
		user.setUsername("GOAT");
		user.setPassword("pass");
	}
	
	@Test
	public void testLogin() {
		log.debug("Begin user login test");
		this.restTemplate.postForEntity("/users/login", user, User.class);
	}
}
