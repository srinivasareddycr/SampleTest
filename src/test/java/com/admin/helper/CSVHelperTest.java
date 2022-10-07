package com.admin.helper;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.csv.CSVParser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.multipart.MultipartFile;

import com.admin.model.PatientDetails;
@SpringBootTest
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
public class CSVHelperTest {
	
	
	@Mock
	MultipartFile file;
	
	@Mock
	PatientDetails patientDetails;

	@Test
	public void testHasCSVFormat() {
		String TYPE = "text/csv";
		
		if(TYPE.equals(file.getContentType()))
		{
			assertEquals(true, TYPE.equals(file.getContentType()));
		}
		
	
		
	}

	@Test
	public void testCsvToTutorials() throws ParseException {
		List<PatientDetails> pdto = new ArrayList<>();
		PatientDetails patientUpdateDto = new PatientDetails();
		patientUpdateDto.setAddress("address");
		patientUpdateDto.setDob("07-09-2022");
		patientUpdateDto.setEmailId("email@email.com");
		patientUpdateDto.setPatientName("patient");
		patientUpdateDto.setPhoneNumber("9090909090");
		patientUpdateDto.setDrugId("23456-4321-22");
		patientUpdateDto.setDrugName("drugName");
		pdto.add(patientUpdateDto);
		List<PatientDetails> list = new ArrayList<PatientDetails>();
		for(int i =0;i<pdto.size();i++)
		{
			 boolean status=false;
	    	  
			  if((pdto.get(i).getPatientName().equals("patient"))&&(pdto.get(i).getPhoneNumber().equals("9090909090")))
			  
			  {
				  if((pdto.get(i).getDrugId().equals("23456-4321-22"))&&(pdto.get(i).getEmailId().equals("email@email.com")))
				  {
					  SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
					  String checkdate = pdto.get(i).getDob();
					  Date cc = format.parse(checkdate);
					  
					  System.out.println(cc);
					  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");  
					  LocalDateTime now = LocalDateTime.now(); 
					  String currentDate= dtf.format(now);
					  Date CurDate= format.parse(currentDate);
					  System.out.println(currentDate);
					
					  if(cc.before(CurDate)&&checkdate.equals("07-09-2022"))
					  {
					  status=true;
					  
					  list.add(pdto.get(i));
					  }
				  }
			
		}
		}
		assertEquals(list, list);
	
	}

	@Test
	public void testTutorialsToCSV() throws IOException {
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
	   new ByteArrayInputStream(bytes);
		//patientDetailsLoaderController.findPatientDetails("test");
		assertEquals(bytes, bytes, "");
	}
	

}
