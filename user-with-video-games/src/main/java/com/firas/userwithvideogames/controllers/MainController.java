package com.firas.userwithvideogames.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.firas.userwithvideogames.services.GameService;
import com.firas.userwithvideogames.services.UserService;

@Controller
public class MainController {
    public final UserService userServ;
    public final GameService gameServ;
    public MainController(UserService userServ, GameService gameServ) {
        this.userServ = userServ;
        this.gameServ = gameServ;
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
        model.addAttribute("allGames", gameServ.getAll());
        model.addAttribute("user", userServ.getUser((Long) session.getAttribute("user_id")));
        return "main/dashboard.jsp";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}