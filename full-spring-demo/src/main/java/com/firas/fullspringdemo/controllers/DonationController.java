package com.firas.fullspringdemo.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.firas.fullspringdemo.models.Donation;
import com.firas.fullspringdemo.services.DonationService;

@Controller
@RequestMapping("/donation")
public class DonationController {
	
	public final DonationService donationServ;

	public DonationController(DonationService donationServ) {
		this.donationServ = donationServ;
	}
	
	@GetMapping("/new")
	public String newDonation(@ModelAttribute("donation") Donation donation, HttpSession session) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
		}
		return "donation/create.jsp";
	}
	
	@PostMapping("/new")
	public String processNewDonation(@Valid @ModelAttribute("donation") Donation donation, BindingResult result) {
		
		if(result.hasErrors()) {
			return "donation/create.jsp";
		}
		donationServ.create(donation);
		return "redirect:/dashboard";
	}
	
	@GetMapping("/edit{id}")
	public String editDonation(Model model, HttpSession session, @PathVariable("id") Long id) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
		}
		model.addAttribute("donaton", donationServ.getOne(id));
		return "donation/edit.jsp";
	}
	
	@PutMapping("/edit/{id}")
	public String processEditDonation(@Valid @ModelAttribute("donation") Donation donation, BindingResult result) {
		if(result.hasErrors()) {
			return "donation/edit.jsp";
		}
		donationServ.update(donation);
		return "redirect:/dashboard";
	}
	
	@GetMapping("/display/{id}")
	public String displayDonation(@PathVariable("id") Long id, HttpSession session, Model model) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
		}
		model.addAttribute("donation", donationServ.getOne(id));
		return "donation/displayOne.jsp";
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteDonation(@PathVariable("id") Long id) {
		donationServ.delete(id);
		return "redirect;/dashboard";
	}

}
