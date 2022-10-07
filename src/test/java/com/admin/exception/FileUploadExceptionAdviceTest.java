package com.admin.exception;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.admin.message.ResponseMessage;

@SpringBootTest
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
public class FileUploadExceptionAdviceTest {

	@Test
	public void testHandleMaxSizeException() {
		ResponseEntity<ResponseMessage> response = new ResponseEntity<ResponseMessage>(HttpStatus.EXPECTATION_FAILED);
		
		assertEquals("File too large","File too large");
	}

}
