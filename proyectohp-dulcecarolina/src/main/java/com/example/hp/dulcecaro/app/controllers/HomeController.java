package com.example.hp.dulcecaro.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller 
public class HomeController {

	@RequestMapping(value="/home", method=RequestMethod.GET)
    public String welcome(Model model){
        model.addAttribute("titulo", "Bienvenido a la tienda virtual!");
        model.addAttribute("nota", "Para consultas escribir al 3416659677.");
        return "home";
    }
	
}
