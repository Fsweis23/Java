package com.firas.sessionformdemo.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {

	@GetMapping("/")
	public String redirectHome() {
		return "redirect:/home";
	}

	@GetMapping("/home")
	public String setCount(HttpSession session) {
		// check if the count is in session.
		if (session.getAttribute("count") == null) {
			// if not, create set to 0
			session.setAttribute("count", 1);
		} else {
			// if it is in session, increment the count in session
//		Integer countInSession = (Integer) session.getAttribute("count");
//		countInSession++;
//		session.setAttribute("count", countInSession++ );

			session.setAttribute("count", (Integer) session.getAttribute("count") + 1);
		}
		return "counter/index.jsp";
	}

	@GetMapping("/display/count")
	public String getCount() {
		return "counter/addCount.jsp";
	}

	@GetMapping("/reset/count")
	public String resetCount(HttpSession session) {
		session.setAttribute("count", 0);
		return "redirect:/display/count";
	}

	@GetMapping("/search/form")
	public String searchForm() {
		return "search/form.jsp";
	}

	@GetMapping("/search")
	public String displaySearch(@RequestParam("keyword") String keyword, Model model) {
		model.addAttribute("keyword", keyword);
		return "search/displayForm.jsp";
	}

	@GetMapping("/review/form")
	public String reviewForm() {
		return "review/form.jsp";
	}

//	@RequestMapping(value="/review/form", method=RequestMethod.POST)
	@PostMapping("/review/form")
	public String processForm(@RequestParam("movie") String movie, @RequestParam("comment") String comment,
			@RequestParam("rating") Integer rating, HttpSession session, RedirectAttributes redirectAttributes,
			@RequestParam("reviewer") String reviewer) {
		if (rating < 0) {
			redirectAttributes.addFlashAttribute("error", "<p style='color:red'> Rating must be more than zero </p>");
			return "redirect:/review/form";
		}
		session.setAttribute("movie", movie);
		session.setAttribute("comment", comment);
		session.setAttribute("rating", rating);
		session.setAttribute("reviewer", reviewer);
		return "redirect:/review/form/data";
	}

	@GetMapping("/review/form/data")
	public String displayReviewForm() {
		return "review/displayForm.jsp";
	}

}
