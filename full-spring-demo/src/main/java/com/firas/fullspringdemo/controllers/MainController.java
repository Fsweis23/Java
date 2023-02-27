package com.firas.fullspringdemo.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.firas.fullspringdemo.services.DonationService;
import com.firas.fullspringdemo.services.UserService;

@Controller
public class MainController {
	
	public final UserService userServ;
	public final DonationService donationServ;
	
	public MainController(UserService userServ, DonationService donationServ) {
		this.userServ = userServ;
		this.donationServ = donationServ;
	}
	
	@GetMapping("/")
	public String loginRedirect() {
		return "redirect:/user/login/register";
	}
	
	@GetMapping("/dashboard")
	public String loginRegisterUser(HttpSession session, Model model) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
		}
		model.addAttribute("allDonations", donationServ.getAll());
		model.addAttribute("loggedInUser", userServ.getUser((Long) session.getAttribute("user_id")));
		return "main/dashboard.jsp";
	}

}
