package com.example.hp.dulcecaro.app.controllers;

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

}
