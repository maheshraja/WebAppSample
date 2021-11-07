package com.yogesh.webapp.dao;

import static org.junit.Assert.*;

import org.junit.Test;

import com.yogesh.webapp.model.User;

public class TestUserDaoImpl {

	@Test
	public void testInsertUser() {
		UserDaoImpl dao = new UserDaoImpl();
		
		User newUser = new User("TestUser", "test@test.com", "123456", 0);
		try {
			dao.insertUser(newUser);
		} catch (Exception e) {
			fail("Insert New user Failed");
		}
	}
	
	@Test
	public void testSelectUser()
	{
		UserDaoImpl dao = new UserDaoImpl();
		
		long id = 1;
		
		try {
			User queriedUser = dao.selectUser(1);
			assertEquals(id, queriedUser.getId());
		} catch (Exception e) {
			fail("Query user Failed");
		}
	}

}
