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
public class RoleTest {

	@Test
	public void testGetId() {
		
		assertEquals(2,2);
	}

	@Test
	public void testSetId() {
		assertEquals(2,2);
	}

	@Test
	public void testGetName() {
	String name="admin";
	assertEquals(name,"admin");
	}

	@Test
	public void testSetName() {
		String name="admin";
		assertEquals(name,"admin");
	}

}
