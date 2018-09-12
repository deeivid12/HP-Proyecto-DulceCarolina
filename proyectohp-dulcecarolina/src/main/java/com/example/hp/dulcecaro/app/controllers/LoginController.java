package com.example.hp.dulcecaro.app.controllers;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {
	
	@GetMapping("/login")
	public String login(Model model, Principal principal, RedirectAttributes flash) { //principal permite validar!
		
		if(principal != null) { //si ya esta logueado, redirigir a /
			flash.addAttribute("info", "Ya ha iniciado sesión anteriormente.");
			return "redirect:/";
		}
		
		model.addAttribute("titulo","Iniciar Sesión");
		return "login";
	}

}
