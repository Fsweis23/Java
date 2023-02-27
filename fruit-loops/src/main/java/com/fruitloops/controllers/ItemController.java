package com.fruitloops.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ItemController {
	
	@GetMapping("/home")
	public String itemCount() {
		return "index.jsp";
	}

}
