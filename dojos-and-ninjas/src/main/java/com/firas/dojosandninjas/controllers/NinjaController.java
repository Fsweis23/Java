package com.firas.dojosandninjas.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.firas.dojosandninjas.models.Ninja;
import com.firas.dojosandninjas.services.DojoService;
import com.firas.dojosandninjas.services.NinjaService;

@Controller
@RequestMapping("/ninja")
public class NinjaController {
	
	public final DojoService dojoServ;
	
	public final NinjaService ninjaServ;
	
	public NinjaController(NinjaService ninjaServ, DojoService dojoServ) {
		this.dojoServ = dojoServ;
		this.ninjaServ = ninjaServ;
	}
	
	@GetMapping("/new")
	public String newNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
		model.addAttribute("allDojos", dojoServ.findAll());
		return "dojosAndNinjas/newNinja.jsp";
	}
	
	@PostMapping("/new")
	public String processNewNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, Model model) {
		ninjaServ.create(ninja);
		return "redirect:/dojo/all";
	}
}