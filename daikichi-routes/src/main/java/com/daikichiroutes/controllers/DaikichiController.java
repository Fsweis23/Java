package com.daikichiroutes.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/daikichi")
public class DaikichiController {

	@RequestMapping("/travel/Honolulu")
	public String daikichi1() {
		return "Congratulations! You will soon travel to Honolulu!";
	}
	
	@RequestMapping(value="/lotto/6", method = RequestMethod.GET)
	public String daikichi2() {
		return "You will take a grand journey in the near future, but be wary of tempting offers";
	}
	
	@GetMapping("/lotto/37")
	public String daikichi3() {
		return "You have enjoyed the fruits of your labor but now is a great time to spend time with family and friends.";
	}
}
