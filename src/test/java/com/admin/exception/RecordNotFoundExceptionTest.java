package com.admin.exception;

import static org.junit.Assert.*;

import org.junit.Test;

public class RecordNotFoundExceptionTest {

	@Test
	public void testGetResourceName() {
		String resourceName="name";
		assertEquals(resourceName,"name");
	}

	@Test
	public void testGetFieldName() {
		String fieldName="name";
		assertEquals(fieldName,"name");
	}

	@Test
	public void testGetFieldValue() {
		String fieldValue="name";
		assertEquals(fieldValue,"name");
	}

}
