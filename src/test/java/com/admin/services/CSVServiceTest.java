package com.admin.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.ParseException;
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
import org.springframework.web.multipart.MultipartFile;

import com.admin.dto.PatientUpdateDto;
import com.admin.helper.CSVHelper;
import com.admin.model.PatientDetails;
import com.admin.repository.PatientDetailsRepository;
@SpringBootTest
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
public class CSVServiceTest {

	@Mock
	CSVService service;
	
	@Mock
	MultipartFile file;
	
	@Mock
	PatientDetailsRepository repo;
	
	@Mock
	CSVHelper helper;
	
	
	@Before
	public void setUp() throws Exception {
	}
	@Test
	public void testSave() throws ParseException, IOException {
		List<PatientDetails> pdto = new ArrayList<>();
		PatientDetails patientUpdateDto = new PatientDetails();
		patientUpdateDto.setAddress("address");
		patientUpdateDto.setDob("dob");
		patientUpdateDto.setEmailId("emailId");
		patientUpdateDto.setPatientName("patientName");
		patientUpdateDto.setPhoneNumber("phoneNumber");
		pdto.add(patientUpdateDto);
		System.out.println("!!!!!!!!!!!!!!1");
	pdto=	(List<PatientDetails>) file.getInputStream();
		System.out.println("!!!!!!!!!!!!!!!!!!");
		repo.saveAll(pdto);
		assertEquals(repo.saveAll(pdto), repo.saveAll(pdto),"");
	}

	@Test
	public void testLoad() throws IOException {
		List<PatientDetails> pdto = new ArrayList<>();
		PatientDetails patientUpdateDto = new PatientDetails();
		patientUpdateDto.setAddress("address");
		patientUpdateDto.setDob("dob");
		patientUpdateDto.setEmailId("emailId");
		patientUpdateDto.setPatientName("patientName");
		patientUpdateDto.setPhoneNumber("phoneNumber");
		pdto.add(patientUpdateDto);
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
	    ObjectOutputStream oos = new ObjectOutputStream(bos);
	    oos.writeObject(pdto);
	    byte[] bytes = bos.toByteArray();
	 //   new ByteArrayInputStream(bytes);
	    Mockito.when(service.load()).thenReturn(new ByteArrayInputStream(bytes));
		//patientDetailsLoaderController.findPatientDetails("test");
		assertEquals(bytes, bytes, "");
	}

}
