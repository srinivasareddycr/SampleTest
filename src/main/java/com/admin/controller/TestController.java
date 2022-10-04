package com.admin.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	
	@GetMapping("/user")
	@PreAuthorize("hasRole('ADMIN')")
	public String getData()
	{
		return "User Test";
	}

}
