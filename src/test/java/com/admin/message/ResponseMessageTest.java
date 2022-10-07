package com.admin.message;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@SpringBootTest
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
public class ResponseMessageTest {

	@Test
	public void testGetMessage() {
		String message ="message";
		assertEquals(message, "message");
	}

	@Test
	public void testSetMessage() {
		String message ="message";
		assertEquals(message, "message");
	}

}
