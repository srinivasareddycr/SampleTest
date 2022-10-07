package com.admin.controller;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import com.admin.dto.PatientUpdateDto;
import com.admin.message.ResponseMessage;
import com.admin.model.PatientDetails;
import com.admin.services.PatientService;
@SpringBootTest
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
public class PatientDetailsLoaderControllerTest {
	@Mock
	PatientDetailsLoaderController patientDetailsLoaderController;
	
	@Mock
	  PatientService patientService;
	
	@Mock
	MultipartFile file;
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testUploadFile() {
		ResponseEntity<ResponseMessage> response = new ResponseEntity<ResponseMessage>(HttpStatus.OK);
		Mockito.when(patientDetailsLoaderController.uploadFile(file)).thenReturn(response);
		patientDetailsLoaderController.uploadFile(file);
		assertEquals("OK", response.getStatusCode().getReasonPhrase());
		
	}

	@Test
	public void testFindPatientDetails() {
		List<PatientUpdateDto> pdto = new ArrayList<>();
		PatientUpdateDto patientUpdateDto = new PatientUpdateDto();
		patientUpdateDto.setAddress("address");
		patientUpdateDto.setDob("dob");
		patientUpdateDto.setEmailId("emailId");
		patientUpdateDto.setPatientName("patientName");
		patientUpdateDto.setPhoneNumber("phoneNumber");
		pdto.add(patientUpdateDto);
		Mockito.when(patientDetailsLoaderController.findPatientDetails("test")).thenReturn(pdto);
		//patientDetailsLoaderController.findPatientDetails("test");
		assertEquals(patientUpdateDto, patientUpdateDto);
	}

	@Test
	public void testUpdate() {
		PatientDetails patientUpdateDto = new PatientDetails();
		patientUpdateDto.setAddress("address");
		patientUpdateDto.setDob("dob");
		patientUpdateDto.setEmailId("emailId");
		patientUpdateDto.setPatientName("patientName");
		patientUpdateDto.setPhoneNumber("phoneNumber");
			  Mockito.when(patientDetailsLoaderController.update(patientUpdateDto, 1)).thenReturn(patientUpdateDto);
			  assertEquals(patientUpdateDto, patientUpdateDto);
		  }
	

	@Test
	public void testTest() {
		Mockito.when(patientDetailsLoaderController.test()).thenReturn("only for admin");
		String str = patientDetailsLoaderController.test();
		assertEquals("only for admin", str);
	}

	@Test
	public void testTestUser() {
		Mockito.when(patientDetailsLoaderController.testUser()).thenReturn("only for User not for admin");
		String str = patientDetailsLoaderController.testUser();
		assertEquals("only for User not for admin", str);
	}

	@Test
	public void testGetAllPatients() {
		
		List<PatientDetails> patientList = new ArrayList<>();
		PatientDetails patientDetails = new PatientDetails();
		patientDetails.setAddress("address");
		patientDetails.setDob("dob");
		patientDetails.setDrugId("drugId");
		patientDetails.setEmailId("emailId");
		patientDetails.setPatientName("patientName");
		patientDetails.setPhoneNumber("phoneNumber");
		patientDetails.setStatus("status");
		Mockito.when(patientService.getAllPatientDetails()).thenReturn(patientList);
		patientList = patientDetailsLoaderController.getAllPatients();
		assertEquals("address", patientDetails.getAddress());
	}

}
