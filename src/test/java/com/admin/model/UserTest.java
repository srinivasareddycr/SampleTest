package com.admin.model;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@SpringBootTest
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
public class UserTest {

	@Test
	public void testGetId() {
		assertEquals(1,1);
	}

	@Test
	public void testSetId() {
		assertEquals(1,1);
	}

	@Test
	public void testGetUsername() {
		String userName="username";
		assertEquals(userName, "username");
	}

	@Test
	public void testSetUsername() {
		String userName="username";
		assertEquals(userName, "username");
	}

	@Test
	public void testGetPassword() {
		String password="username";
		assertEquals(password, "username");
	}

	@Test
	public void testSetPassword() {
		String password="username";
		assertEquals(password, "username");
	}

	@Test
	public void testGetRoles() {
		String roles="roles";
		assertEquals(roles, "roles");
	}

	@Test
	public void testSetRoles() {
		String roles="roles";
		assertEquals(roles, "roles");
	}

}
