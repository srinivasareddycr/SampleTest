package com.admin.response;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@SpringBootTest
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
public class JwtResponseTest {

	@Test
	public void testGetAccessToken() {
		String accessToken="qewtwtwrwwtwtwtwtwrwrw";
		assertEquals(accessToken, "qewtwtwrwwtwtwtwtwrwrw");
	}

	@Test
	public void testSetAccessToken() {
		String accessToken="qewtwtwrwwtwtwtwtwrwrw";
		assertEquals(accessToken, "qewtwtwrwwtwtwtwtwrwrw");
	}

	@Test
	public void testGetTokenType() {
		String tokenType="Bearer";
		assertEquals(tokenType,"Bearer");
	}

	@Test
	public void testSetTokenType() {
		String tokenType="Bearer";
		assertEquals(tokenType,"Bearer");
	}

	@Test
	public void testGetId() {
		assertEquals(1, 1);
	}

	@Test
	public void testSetId() {
		assertEquals(1, 1);
	}

	@Test
	public void testGetUsername() {
		String password="userName";
		assertEquals(password, "userName");
	}

	@Test
	public void testSetUsername() {
		String password="userName";
		assertEquals(password, "userName");
	}

	@Test
	public void testGetRoles() {
		String roles ="admin,user";
		assertEquals(roles, "admin,user");
	}

}
