package com.firas.mvcdemo.controllers;

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
import org.springframework.web.bind.annotation.RequestParam;

import com.firas.mvcdemo.models.Donation;
import com.firas.mvcdemo.services.DonationService;

@Controller
@RequestMapping("/donation")
public class DonationController {
	
	public final DonationService donationServ;
	public DonationController(DonationService donationServ) {
		this.donationServ = donationServ;
	}
	
	@GetMapping("/all")
	public String showAllDonations(Model model) {
		model.addAttribute("allDoantions", donationServ.findAll());
		return "donation/showAll.jsp";
	}
	
	@GetMapping("/show/{id}")
	public String showOneDonation(@PathVariable("id") Long id, Model model) {
		model.addAttribute("oneDonation", donationServ.getOne(id));
		return "donation/showOne.jsp";
	}
	
	@GetMapping("/new")
//	public String newDonation(@ModelAttribute("donation") Donation donation) {
//		return "donation/createForm.jsp";
//	public String newDonation(Model model) {
//		model.addAttribute("donation", new Donation());
	public String newDonation(@ModelAttribute("donation") Donation donation) {
		return "donation/createForm.jsp";
	}
	
	@PostMapping("/new")
	public String processNewDonation(@Valid @ModelAttribute("donation") Donation donation, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("allDonations", donationServ.findAll());
			return "donation/showAllWithCreate.jsp";
		}
		donationServ.create(donation);
		return "redirect:/donation/all";
	}
	
	@GetMapping("/edit/{id}")
	public String editDonation(@PathVariable("id") Long id, Model model) {
		Donation donation = donationServ.getOne(id);
		model.addAttribute("donation", donation);
		return "donation/editForm.jsp";
	}
	
	@PutMapping("/edit/{id}")
	public String processEditDonation(@Valid @ModelAttribute("donation") Donation donation, BindingResult result) {
		if(result.hasErrors()) {
			return "donation/editForm.jsp";
		}
		donationServ.update(donation);
		return "redirect:/donation/all";
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteDonation(@PathVariable("id") Long id) {
		donationServ.Delete(id);
		return "redirect:/donation/all";
	}
	
	@GetMapping("/all/new")
	public String showAllAndCreate(@ModelAttribute("donation") Donation donation, Model model) {
		model.addAttribute("allDonations", donationServ.findAll());
		return "donation/showAllWithCreate.jsp";
	}
	
	@GetMapping("/search")
	public String searchDonation(@RequestParam("search") String search, Model model) {
		model.addAttribute("searchDonations", donationServ.donationSearch(search));
		return "donation/search.jsp";
	}
}
