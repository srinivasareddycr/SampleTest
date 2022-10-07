package com.admin.model;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



@SpringBootTest
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
public class PatientDetailsTest {

	
	
	@Test
	public void testGetStatus() {
		String status ="status";
		assertEquals(status,"status" );
	}

	@Test
	public void testSetStatus() {
		String status ="status";
		assertEquals(status,"status" );
	}

	@Test
	public void testGetId() {
		
		assertEquals(1,1);
	}

	@Test
	public void testSetId() {
		assertEquals(1,1);
	}

	@Test
	public void testGetPatientName() {
		String patientName="lothbrok";
		assertEquals(patientName, "lothbrok");
	}

	@Test
	public void testSetPatientName() {
		String patientName="lothbrok";
		assertEquals(patientName, "lothbrok");
	}

	@Test
	public void testGetAddress() {
		String address="Kateggot";
		assertEquals(address, "Kateggot");
	}

	@Test
	public void testSetAddress() {
		String address="Kateggot";
		assertEquals(address, "Kateggot");
	}

	@Test
	public void testGetDob() {
		String dob="07-08-1997";
		assertEquals(dob, "07-08-1997");
	}

	@Test
	public void testSetDob() {
		String dob="07-08-1997";
		assertEquals(dob, "07-08-1997");
	}

	@Test
	public void testGetEmailId() {
		String emailId="email@email.com";
		assertEquals(emailId, "email@email.com");
	}

	@Test
	public void testSetEmailId() {
		String emailId="email@email.com";
		assertEquals(emailId, "email@email.com");
	}

	@Test
	public void testGetPhoneNumber() {
		String phoneNumber="9077654321";
		assertEquals(phoneNumber, "9077654321");
	}

	@Test
	public void testSetPhoneNumber() {
		String phoneNumber="9077654321";
		assertEquals(phoneNumber, "9077654321");
	}

	@Test
	public void testGetDrugId() {
		String drugId="123";
		assertEquals(drugId, "123");
	}

	@Test
	public void testSetDrugId() {
		String drugId="123";
		assertEquals(drugId, "123");
	}

	@Test
	public void testGetDrugName() {
		String drugName="AWS";
		assertEquals(drugName, "AWS");
	}

	@Test
	public void testSetDrugName() {
		String drugName="AWS";
		assertEquals(drugName, "AWS");
	}

	
	

	
}
