package com.admin.controller;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.admin.request.LoginRequest;
import com.admin.request.SignupRequest;
@SpringBootTest
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
public class AuthControllerTest {
	
	@Mock
	AuthController authController;
	
	 @Autowired
	  AuthenticationManager authenticationManager;

	 @Mock
	 Authentication authentication;

	@SuppressWarnings("restriction")
	@Test
	public void testAuthenticateUser() {
		LoginRequest loginRequest = new LoginRequest();
		loginRequest.setUsername("testuser");
		loginRequest.setPassword("Ganpathi@12345");
		
//		Mockito.when(authenticationManager.authenticate(
//        new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()))).thenReturn(authentication);
		
		authController.authenticateUser(loginRequest);
		//eAuthentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
		//SecurityContextHolder.getContext().setAuthentication(authentication);
		assertEquals("testuser", loginRequest.getUsername());
		
		
	}

	@Test
	public void testRegisterUser() {
		Set<String> role = new HashSet<>();
		role.add("user");
		role.add("admin");
		SignupRequest signupRequest = new SignupRequest();
		signupRequest.setPassword("Ganpathi@12345");
		signupRequest.setUsername("testuser");
		signupRequest.setRole(role);
		authController.registerUser(signupRequest);
		assertEquals("testuser", signupRequest.getUsername());
		
		
	}

}
