package com.example.hp.dulcecaro.app.controllers;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {
	
	@GetMapping("/login")
	public String login(@RequestParam(value="error", required=false) String error, Model model, Principal principal, RedirectAttributes flash) { //principal permite validar!
		
		if(principal != null) { //si ya esta logueado, redirigir a /
			flash.addFlashAttribute("info", "Ya ha iniciado sesión anteriormente.");
			return "redirect:/home";
		}
		
		if (error != null) {
			model.addAttribute("danger", "Nombre de Usuario o Contraseña incorrectos. Por favor, ingrese nuevamente.");
		} //se usa model porque el mensaje se carga en la misma vista, no redirecciona como con flash)
		
		return "login";
	}
	
	
	@RequestMapping(value= "/forgotPassword", method=RequestMethod.GET)
	public String forgot(Model model) {
		
	
		return "forgotPassword";
	}

}
