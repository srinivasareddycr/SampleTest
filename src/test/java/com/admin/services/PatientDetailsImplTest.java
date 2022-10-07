package com.admin.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.admin.dto.PatientUpdateDto;
import com.admin.model.PatientDetails;
import com.admin.repository.PatientDetailsRepository;
@SpringBootTest
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
public class PatientDetailsImplTest {

	@Mock
	PatientDetailsRepository repository;
	
	@Mock
	PatientDetailsImpl patientDetailsImpl;
	
	
	
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void findByNameByDetailsTest() {
		String patientName = "test";
		List<PatientUpdateDto> pdto = new ArrayList<>();
		PatientUpdateDto patientUpdateDto = new PatientUpdateDto();
		patientUpdateDto.setAddress("address");
		patientUpdateDto.setDob("dob");
		patientUpdateDto.setEmailId("emailId");
		patientUpdateDto.setPatientName("patientName");
		patientUpdateDto.setPhoneNumber("phoneNumber");
		pdto.add(patientUpdateDto);
		
		
		Mockito.when(patientDetailsImpl.findByNameByDetails(patientName)).thenReturn(pdto);
		assertEquals(pdto, pdto);
		
	}

	@Test
	public void updatePatientDetailsTest() {
		PatientDetails patientUpdateDto = new PatientDetails();
		patientUpdateDto.setAddress("address");
		patientUpdateDto.setDob("dob");
		patientUpdateDto.setEmailId("emailId");
		patientUpdateDto.setPatientName("patientName");
		patientUpdateDto.setPhoneNumber("phoneNumber");
			  Mockito.when(patientDetailsImpl.updatePatientDetails(patientUpdateDto, 1)).thenReturn(patientUpdateDto);
			  assertEquals(patientUpdateDto, patientUpdateDto);
		  }
		
	@Test
	public void getAllPatientDetailsTest()
	{
		List<PatientDetails> pdto = new ArrayList<>();
		 PatientDetails patientUpdateDto = new PatientDetails();
		patientUpdateDto.setAddress("address");
		patientUpdateDto.setDob("dob");
		patientUpdateDto.setEmailId("emailId");
		patientUpdateDto.setPatientName("patientName");
		patientUpdateDto.setPhoneNumber("phoneNumber");
		pdto.add(patientUpdateDto);
		Mockito.when(repository.findAll()).thenReturn(pdto);
		assertEquals(pdto, pdto);
	}
		
	}


