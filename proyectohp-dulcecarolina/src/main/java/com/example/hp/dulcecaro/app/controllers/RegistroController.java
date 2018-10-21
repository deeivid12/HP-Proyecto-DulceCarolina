package com.example.hp.dulcecaro.app.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.example.hp.dulcecaro.app.models.entity.Usuario;
import com.example.hp.dulcecaro.app.models.entity.UsuarioDTO;
import com.example.hp.dulcecaro.app.models.service.UsuarioServiceImpl;
import com.example.hp.dulcecaro.app.validations.UsuarioExisteException;

@Controller
public class RegistroController {
	
	@Autowired
	private UsuarioServiceImpl uService; 
	
	@RequestMapping(value="/registro", method=RequestMethod.GET)
	public String showRegistrationForm(WebRequest request, Model model) {
		
		UsuarioDTO usuarioDTO = new UsuarioDTO();
		model.addAttribute("usuario", usuarioDTO);
		
		return "registro";
	}
	
	
	@RequestMapping (value="/registro", method=RequestMethod.POST)
	public ModelAndView registrarUsuario(
			@ModelAttribute("usuario") @Valid UsuarioDTO cuentaDTO,
			BindingResult result,
			WebRequest request,
			Errors errors) {
			
		Usuario registrado = new Usuario();
		
		//validacion de email duplicado
		
		
		registrado = crearCuentaUsuario(cuentaDTO, result);
		
		if(registrado == null) {
			result.rejectValue("username", "message.regError","Ya existe un Usuario registrado con ese Email. Por favor, intente con otro nuevamente.");
		}
		
		return new ModelAndView("registro","usuario", cuentaDTO);
		
	}
	
	
	private Usuario crearCuentaUsuario(UsuarioDTO cuentaDTO, BindingResult result) {
		
		Usuario registrado = null;
		try {
		registrado = uService.registrarNuevoUsuario(cuentaDTO);
		} catch (UsuarioExisteException e) {
			return null;
		}
		return registrado;
	}
	
	
	

}
