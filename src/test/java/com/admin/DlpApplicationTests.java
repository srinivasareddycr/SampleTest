package com.admin;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.admin.model.PatientDetails;
import com.admin.repository.PatientDetailsRepository;
import com.admin.services.CSVService;
import com.admin.services.PatientService;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest

class DlpApplicationTests {

	private MockMvc mockMvc;
	@Autowired
	private WebApplicationContext context;

	ObjectMapper om = new ObjectMapper();

	//	@Before(value = "")
	//	public void setUp() {
	//		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	//	}

	@Test
	void contextLoads() {
	}

	@Autowired
	private CSVService csvService;

	@Autowired
	private WebApplicationContext webApplicationContext;
	@Autowired
	private PatientService patientService;

	@MockBean
	private  PatientDetailsRepository repository;

	@Before(value = "whenFileUploaded_thenVerifyStatus")
	private void setUp()
	{
		mockMvc=MockMvcBuilders.webAppContextSetup(context).build();
	}

	@Test
	public void getAllPatientDeatilsTest() {
		when (repository.findAll()).thenReturn(Stream.of(new  PatientDetails("pune","Sreeni,","SREEBU","sreeni","sreeni","sreeni","sreeni")).collect(Collectors.toList()));
		assertEquals(1,patientService.getAllPatientDetails().size());
	}

	@Test
	public void getAllByte() {
		when(repository.findAll()).thenReturn(Stream.of(new  PatientDetails("pune","Sreeni,","SREEBU","sreeni","sreeni","sreeni","sreeni")).collect(Collectors.toList()));
		assertEquals(1,csvService.load());

	}


	@Test
	public void whenFileUploaded_thenVerifyStatus() 
			throws Exception {
		MockMultipartFile file 
		= new MockMultipartFile(
				"file", 
				"hello.csv", 
				MediaType.TEXT_PLAIN_VALUE, 
				"Hello, World!".getBytes()
				);

		MockMvc mockMvc 
		= MockMvcBuilders.webAppContextSetup(context).build();
		mockMvc.perform(multipart("/api/load/patientdata").file(file))
		.andExpect(status().isOk());
	}















}












