package com.admin.dto;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@SpringBootTest
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
public class PatientUpdateDtoTest {

	@Test
	public void testGetPatientName() {
		String patientName="Magnus";
		assertEquals(patientName, "Magnus");
	}

	@Test
	public void testSetPatientName() {
		String patientName="Magnus";
		assertEquals(patientName, "Magnus");
	}

	@Test
	public void testGetAddress() {
		String address="Mercia";
		assertEquals(address, "Mercia");
	}

	@Test
	public void testSetAddress() {
		String address="Mercia";
		assertEquals(address, "Mercia");
	}

	@Test
	public void testGetDob() {
		String dob="09-09-2021";
		assertEquals(dob, "09-09-2021");
	}

	@Test
	public void testSetDob() {
		String dob="09-09-2021";
		assertEquals(dob, "09-09-2021");
	}

	@Test
	public void testGetEmailId() {
		String emailId="patient@email.com";
		assertEquals(emailId, "patient@email.com");
	}

	@Test
	public void testSetEmailId() {
		String emailId="patient@email.com";
		assertEquals(emailId, "patient@email.com");
	}

	@Test
	public void testGetPhoneNumber() {
		String phoneNumber="9998877665";
		assertEquals(phoneNumber, "9998877665");
	}

	@Test
	public void testSetPhoneNumber() {
		String phoneNumber="9998877665";
		assertEquals(phoneNumber, "9998877665");
	}

}
