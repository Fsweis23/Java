package com.firas.javaexam.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.firas.javaexam.services.UserService;
import com.firas.javaexam.services.YogaService;

@Controller
public class MainController {

	    public final UserService userServ;
	    public final YogaService yogaServ;
	    public MainController(UserService userServ, YogaService yogaServ) {
	        this.userServ = userServ;
	        this.yogaServ = yogaServ;
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
	        model.addAttribute("allYoga", yogaServ.getAll());
	        model.addAttribute("user", userServ.getUser((Long) session.getAttribute("user_id")));
	        return "main/dashboard.jsp";
	    }

	    @GetMapping("/logout")
	    public String logout(HttpSession session) {
	        session.invalidate();
	        return "redirect:/";
	    }
	}