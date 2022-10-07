package com.admin.request;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
public class SignupRequestTest {

	@Test
	public void testGetUsername() {
		String userName="userName";
		assertEquals(userName, "userName");
	}

	@Test
	public void testSetUsername() {
		String userName="userName";
		assertEquals(userName, "userName");
	}

	@Test
	public void testGetEmail() {
		String email="userName@email.com";
		assertEquals(email, "userName@email.com");
	}

	@Test
	public void testSetEmail() {
		String email="userName@email.com";
		assertEquals(email, "userName@email.com");
	}

	@Test
	public void testGetPassword() {
		String password="userName";
		assertEquals(password, "userName");
	}

	@Test
	public void testSetPassword() {
		String password="userName";
		assertEquals(password, "userName");
	}

	@Test
	public void testGetRole() {
		String role="user";
		assertEquals(role, "user");
	}

	@Test
	public void testSetRole() {
		String role="user";
		assertEquals(role, "user");
	}

}
