package com.example.hp.dulcecaro.app.controllers;

import java.security.Principal;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DashboardController {
	
	@RequestMapping(value="/dashboard")
	public String dashboard(Model model) {
		
		model.addAttribute("dashboard", "");
		
		return "dashboard";
	}
	
	@RequestMapping(value="/miCuenta")
	public String miCuenta(Model model, Principal principal) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		
		model.addAttribute("miCuenta", name);
		
		return "miCuenta";
	}
	
	

}
