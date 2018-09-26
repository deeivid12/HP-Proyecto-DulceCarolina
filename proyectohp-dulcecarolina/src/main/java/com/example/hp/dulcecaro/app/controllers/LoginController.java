package com.example.hp.dulcecaro.app.controllers;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {
	
	@GetMapping("/login")
	public String login(@RequestParam(value="error", required=false) String error, Model model, Principal principal, RedirectAttributes flash) { //principal permite validar!
		
		if(principal != null) { //si ya esta logueado, redirigir a /
			flash.addFlashAttribute("info", "Ya ha iniciado sesión anteriormente.");
			return "redirect:/listarMateriasPrima";
		}
		
		if (error != null) {
			model.addAttribute("error", "Nombre de Usuario o Contraseña incorrectos. Por favor, ingrese nuevamente.");
		} //"error" es el tipo de mensaje que se va a enviar! (en color rojo, por ejemplo)
		
		//model.addAttribute("titulo","Iniciar Sesión");
		return "login";
	}
	
	//PARA QUE FUNCIONEN LOS MENSAJES DE EXITO, ERROR, INFO, ETC, HAY QUE CONFIGURARLOS EN EL LAYOUT! 
	//ES DECIR, CONFIGURAR UN LAYOUT Y DESPUES CARGARLO POR DEFECTO EN TODAS LAS VISTAS DEL SISTEMA.
	//PENDIENTE, HAY QUE HACERLO!!

}
