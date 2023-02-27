package com.firas.projecttwo.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.firas.projecttwo.services.DogService;
import com.firas.projecttwo.services.UserService;

@Controller
public class MainController {

	    public final UserService userServ;
	    public final DogService dogServ;
	    public MainController(UserService userServ, DogService dogServ) {
	        this.userServ = userServ;
	        this.dogServ = dogServ;
	    }
	    
	    @GetMapping("/")
	    public String redirectLogin() {
	    	return "redirect:/user/";
	    }
	    
	    @GetMapping("/dashboard")
	    public String dashboard(HttpSession session, Model model) {
	        if(session.getAttribute("user_id") == null) {
	            return "redirect:/";
	        }
	        model.addAttribute("allDogs", dogServ.getAll());
	        model.addAttribute("user", userServ.getUser((Long) session.getAttribute("user_id")));
	        return "main/dashboard.jsp";
	    }

	    @GetMapping("/logout")
	    public String logout(HttpSession session) {
	        session.invalidate();
	        return "redirect:/";
	    }
	}