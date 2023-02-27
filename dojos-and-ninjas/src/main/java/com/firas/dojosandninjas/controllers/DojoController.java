package com.firas.dojosandninjas.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.firas.dojosandninjas.models.Dojo;
import com.firas.dojosandninjas.services.DojoService;
import com.firas.dojosandninjas.services.NinjaService;

@Controller
@RequestMapping("/dojo")
public class DojoController {
	
	public final DojoService dojoServ;
	
	public final NinjaService ninjaServ;
	
	public DojoController(DojoService dojoServ, NinjaService ninjaServ) {
		this.ninjaServ = ninjaServ;
		this.dojoServ = dojoServ;
	}
	
	@GetMapping("/all")
	public String showAllDojos(Model model) {
		model.addAttribute("allDojos", dojoServ.findAll());
		return "dojosAndNinjas/allDojos.jsp";
	}
	
	@GetMapping("/show/{id}")
	public String showOneDojo(@PathVariable("id") Long id, Model model) {
		model.addAttribute("allNinjas", ninjaServ.findAllByDojo(id));
		model.addAttribute("oneDojo", dojoServ.getOne(id));
		return "dojosAndNinjas/locationsTable.jsp";
	}
	
	@GetMapping("/new")
	public String newDojo(@ModelAttribute("dojo") Dojo dojo) {
		return "dojosAndNinjas/newDojo.jsp";
	}
	
	@PostMapping("/new")
	public String processNewDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("allDojos", dojoServ.findAll());
			return "redirect;/dojo/all";
		}
		dojoServ.create(dojo);
		return "redirect:/dojo/all";
	}
	
}