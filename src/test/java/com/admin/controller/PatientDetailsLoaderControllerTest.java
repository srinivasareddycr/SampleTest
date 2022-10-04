package com.admin.controller;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.admin.dto.PatientUpdateDto;
import com.admin.services.CSVService;
import com.admin.services.PatientService;
import com.fasterxml.jackson.databind.ObjectMapper;

//@ExtendWith(SpringExtension.class)
//@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class PatientDetailsLoaderControllerTest {

	 @Autowired
	  MockMvc mockMvc;
	 
	 @Autowired
	 private WebApplicationContext context;
	
	@Mock
	PatientDetailsLoaderController patientDetailsLoaderController;
	
	@Mock
	 CSVService fileService;
	
	@Mock 
	PatientService patientService;
	
	ObjectMapper omp= new ObjectMapper();
	
//	@Before
//	private void setup()
//	{
//		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
//	}
//	
//	 private InputStream is;
//	 
//	 @InjectMocks
//	    private PatientDetailsLoaderController controller = new PatientDetailsLoaderController();
//	    @Before
//	    public void init() {
//	        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
//	        is = controller.getClass().getClassLoader().getResourceAsStream("excel.csv");
//	    }
	
	 @Before
	    public void setup() {
	       this.mockMvc = MockMvcBuilders.webAppContextSetup(context)
	           .alwaysDo(MockMvcResultHandlers.print())
	           .build();
	    }
	
	@Test
	void testUploadFile() throws Exception {
//		MockMultipartFile file = 
//			       new MockMultipartFile(
//			    	        "file", 
//			    	        "hello.csv", 
//			    	        MediaType.TEXT_PLAIN_VALUE, 
//			    	        "Hello, World!".getBytes());
//	patientDetailsLoaderController.uploadFile(file);
//	fileService.save(file);
//		assertEquals("Uploaded the file successfully:hello.txt","Uploaded the file successfully:hello.txt" );
//		System.out.println("String test...");
		
		 //public void test_handleFileUpload() throws Exception{
		 
//		

		  
//	 
//	    Path docRootPath = Path.of(documentRoot, fileName);
//	    filesToBeDeleted.add(docRootPath);
//	    assertThat(Files.exists(docRootPath)).isTrue();
	
		
		
	

	
//
//	@Test
//	void testUpdate() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testTest() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testTestUser() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetAllPatients() {
//		fail("Not yet implemented");
//	}

		
//	
//		    //given
//		    InputStream uploadStream = PatientDetailsLoaderControllerTest.class.getClassLoader().getResourceAsStream("test.csv");
//		    MockMultipartFile file = new MockMultipartFile("file", uploadStream);
//		    assert uploadStream != null;
//
//		    //when
//		    this.mockMvc.perform(fileUpload("/api/load/patientdata")
//		            .file(file))
//		    //then
//		            .andExpect(status().isOk());
		
		
		
//		        MockMultipartFile mockMultipartFile = new MockMultipartFile("file", "excel.csv", "multipart/form-data", is);
//		        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.multipart("/api/load/patientdata").file(mockMultipartFile).contentType(MediaType.MULTIPART_FORM_DATA))
//		                .andExpect(MockMvcResultMatchers.status().is(200)).andReturn();
//		        Assert.assertEquals(200, result.getResponse().getStatus());
//		        Assert.assertNotNull(result.getResponse().getContentAsString());
//		        Assert.assertEquals("excel.csv", result.getResponse().getContentAsString());
////		

		
		//MockMultipartFile mmf =  new MockMultipartFile(name:"file", originalFileName:"test-file.txt",contentType:"text/plain",content:"simple text ".getBytes());
		
		

	 
//		
//			MockMultipartFile multipartFile = new MockMultipartFile("file", "test.txt",
//					"text/plain", "Spring Framework".getBytes());
//			this.mockMvc.perform(multipart("/").file(multipartFile))
//					.andExpect(status().isFound())
//					.andExpect(header().string("Location", "/"));
//			then(this.fileService).should().store(multipartFile);
		

		    
		        String text ="Text to be uploaded.";
		        MockMultipartFile file = new MockMultipartFile("file","test.txt", "text/plain", text.getBytes());
		        mockMvc.perform(MockMvcRequestBuilders.multipart("/patientdata")
		               .file(file)
		               .characterEncoding("UTF-8"))
		               .andExpect(MockMvcResultMatchers.status().isOk());
		    }
		
	
//	@Test
//	void testFindPatientDetails() throws Exception {
//		MvcResult  result =mockMvc.perform(get("/api/load/getAll").content(MediaType.APPLICATION_JSON_VALUE))
//				.andExpect(status().isOk()).andReturn();
//		String resultContent =  result.getResponse().getContentAsString();
//		Response response =  omp.readValue(resultContent, Response.class);
//		Assert.assertEquals(patientService.getAllPatientDetails(),response);
//	}
		
	}
	
	


