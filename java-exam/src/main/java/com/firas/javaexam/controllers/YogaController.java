package com.firas.javaexam.controllers;

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

import com.firas.javaexam.models.Yoga;
import com.firas.javaexam.services.YogaService;

@Controller
@RequestMapping("/yoga")
public class YogaController {

	public final YogaService yogaServ;
	
    public YogaController(YogaService yogaServ) {
        this.yogaServ = yogaServ;
    }
    
    @GetMapping("/new")
    public String newYoga(@ModelAttribute("yoga") Yoga yoga, HttpSession session) {
    	System.out.println("Inside Form GET Route method");
    	if(session.getAttribute("user_id") == null) {
    		return "redirect:/";
    	}
    	return "yoga/create.jsp";
    }
    
    @PostMapping("/new")
    public String processNewYoga(@Valid @ModelAttribute("yoga") Yoga yoga, BindingResult result) {
    	if(result.hasErrors()) {
    		return "yoga/create.jsp";
    	}
    	yogaServ.create(yoga);
    	return "redirect:/dashboard";
    }
//    	System.out.println(yoga.getClassName());
//    	System.out.println("Inside post processing route");
//    	if(result.hasErrors()) {
//    		System.out.println("inside errors conditional");
//    	    for (FieldError error : result.getFieldErrors() ) {
//    	        System.out.println (error.getObjectName() + " - " + error.getDefaultMessage());
//    	    }
//    		return "yoga/create.jsp";
//    	}
    
    @GetMapping("/display/{id}")
    public String displayYoga(@PathVariable("id") Long id, HttpSession session, Model model) {
        if(session.getAttribute("user_id") == null) {
            return "redirect:/";
        }
        model.addAttribute("yoga", yogaServ.getOne(id));
        return "yoga/displayOne.jsp";
    }
    
    @GetMapping("/edit/{id}")
    public String editYoga(@PathVariable("id") Long id, Model model, HttpSession session) {
        if(session.getAttribute("user_id") == null) {
            return "redirect:/dashboard";
        }
        model.addAttribute("yoga", yogaServ.getOne(id));
        return "yoga/edit.jsp";
    }
    
    @PutMapping("/edit/{id}")
    public String processEditYoga(@Valid @ModelAttribute("yoga") Yoga yoga, BindingResult result) {
    	if(result.hasErrors()) {
    		return "yoga/edit.jsp";
    	}
    	yogaServ.update(yoga);
    	return "redirect:/yoga/display/" + yoga.getId();
    }
    
    @DeleteMapping("/delete/{id}")
    public String deleteYoga(@PathVariable("id") Long id) {
        yogaServ.delete(id);
        return "redirect:/dashboard";
    }
}