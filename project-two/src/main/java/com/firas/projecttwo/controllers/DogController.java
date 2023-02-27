package com.firas.projecttwo.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.firas.projecttwo.models.Dog;
import com.firas.projecttwo.services.DogService;

@Controller
@RequestMapping("/dog")
public class DogController {
	
	public final DogService dogServ;
		
	    public DogController(DogService dogServ) {
	        this.dogServ = dogServ;
	    }
	    
	    @GetMapping("/new")
	    public String newDog(@ModelAttribute("dog") Dog dog, HttpSession session, Model model) {
	    	System.out.println("Inside Form GET Route method");
	    	model.addAttribute("dogImgUrl", dogServ.getDogImg(null));
	    	System.out.println(dogServ.getDogImg(null));
	    	if(session.getAttribute("user_id") == null) {
	    		return "redirect:/";
	    	}
	    	return "main/dashboard.jsp";
	    }
	    
	    @PostMapping("/new")
	    public String processNewDog(@Valid @ModelAttribute("dog") Dog dog, BindingResult result) {
	    	if(result.hasErrors()) {
	    		return "dog/create.jsp";
	    	}
	    	dogServ.create(dog);
	    	return "redirect:/dashboard";
	    }
}
