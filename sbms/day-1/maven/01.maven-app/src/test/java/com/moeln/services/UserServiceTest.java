package com.moeln.services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UserServiceTest {

	@Test
	void testFindUserNameById() {
		int uid = 101;
		UserService uService = new UserService();
		String uName = uService.findUserNameById(uid);
		assertEquals("Sanjay", uName);
	}

	@Test
	void testFindUserNameById_01() {
		int uid = 102;
		UserService uService = new UserService();
		String uName = uService.findUserNameById(uid);
		assertNull(uName);
	}
}
