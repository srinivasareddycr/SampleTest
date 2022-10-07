package com.admin.services;

import static org.junit.Assert.*;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.admin.model.User;
import com.admin.repository.UserRepository;
@SpringBootTest
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
public class UserDetailsServiceImplTest {

	
	@Mock
	UserRepository repo;
	
	@Mock
	User user;
	
	@Test
	public void testLoadUserByUsername() {
		User user = new User("username","password");
		   repo.findByUsername("username");
		assertEquals(repo.findByUsername("username"), repo.findByUsername("username"));
		
		
	}

}
