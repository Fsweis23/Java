package com.firas.firstspringdemo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

	@RequestMapping("/api")
	public String apiTest() {
		return "Hello World";
	}
	
	@GetMapping("/api/number")
	public int numberTest() {
		return 7;
	}
}
