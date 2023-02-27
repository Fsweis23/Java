package com.firas.userwithvideogames.controllers;

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

import com.firas.userwithvideogames.models.Game;
import com.firas.userwithvideogames.services.GameService;

@Controller
@RequestMapping("/game")
public class GameController {
	
	public final GameService gameServ;
	
    public GameController(GameService gameServ) {
        this.gameServ = gameServ;
    }
    
    @GetMapping("/new")
    public String newGame(@ModelAttribute("game") Game game, HttpSession session) {
    	if(session.getAttribute("user_id") == null) {
    		return "redirect:/";
    	}
    	return "game/create.jsp";
    }
    
    @PostMapping("/new")
    public String processNewGame(@Valid @ModelAttribute("game") Game game, BindingResult result) {
    	if(result.hasErrors()) {
    		return "game/create.jsp";
    	}
    	gameServ.create(game);
    	return "redirect:/dashboard";
    }
    
    @GetMapping("/display/{id}")
    public String displayGame(@PathVariable("id") Long id, HttpSession session, Model model) {
        if(session.getAttribute("user_id") == null) {
            return "redirect:/";
        }
        model.addAttribute("game", gameServ.getOne(id));
        return "game/displayOne.jsp";
    }
    
    @GetMapping("/edit/{id}")
    public String editGame(@PathVariable("id") Long id, Model model, HttpSession session) {
        if(session.getAttribute("user_id") == null) {
            return "redirect:/";
        }
        model.addAttribute("game", gameServ.getOne(id));
        return "game/edit.jsp";
    }
    
    @PutMapping("/edit/{id}")
    public String processEditGame(@Valid @ModelAttribute("game") Game game, BindingResult result) {
    	if(result.hasErrors()) {
    		return "game,edit.jsp";
    	}
    	gameServ.update(game);
    	return "redirect:/game/display/" + game.getId();
    }
    
    @DeleteMapping("/delete/{id}")
    public String deleteGame(@PathVariable("id") Long id) {
        gameServ.delete(id);
        return "redirect:/dashboard";
    }
}