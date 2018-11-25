/*package com.example.hp.dulcecaro.app.controllers;

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
*/

package com.example.hp.dulcecaro.app.controllers;  //david

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.hp.dulcecaro.app.models.entity.MateriaPrima;
import com.example.hp.dulcecaro.app.models.entity.Rol;
import com.example.hp.dulcecaro.app.models.entity.Usuario;
import com.example.hp.dulcecaro.app.models.entity.UsuarioDTO;
import com.example.hp.dulcecaro.app.models.service.JpaUserDetailsService;
import com.example.hp.dulcecaro.app.models.service.UsuarioServiceImpl;
import com.example.hp.dulcecaro.app.validations.UsuarioExisteException;


@Controller
@SessionAttributes("uActual")
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
			WebRequest request,
			BindingResult result,
			Model model,
			RedirectAttributes flash,
			Errors errors) {
			
		Usuario registrado = new Usuario();
		
		//validacion de email duplicado
		
		
		registrado = crearCuentaUsuario(cuentaDTO, result);
		
		if(registrado == null) {
			model.addAttribute("danger", "Email ya registrado. Por favor, intente con otro nuevamente.");
			result.rejectValue("username", "message.regError","Ya existe un Usuario registrado con ese Email. Por favor, intente con otro nuevamente.");
		} else {
			model.addAttribute("success","Usuario registrado con éxito.");
		}
		
		//return new ModelAndView("registro","usuario", cuentaDTO);	
		return new ModelAndView("login");			

		
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
	
	
	@RequestMapping (value="/miCuenta", method=RequestMethod.GET)
	public String miCuenta(
			//@ModelAttribute("usuario") @Valid UsuarioDTO cuentaDTO,
			Map<String, Object> model)
			 {
		
		
		
		Usuario uActual = new Usuario();
		uActual = uService.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
		model.put("uActual", uActual);
		model.put("roles", uActual.getRoles());
		model.put("oldPass", uActual.getPassword());
		
		return "miCuenta"; 
	}
	
	@RequestMapping (value="/miCuenta", method=RequestMethod.POST)
	public String guardar(@Valid Usuario uActual, BindingResult result, Model model, SessionStatus status,
			@RequestParam("password") String password, RedirectAttributes flash) {
				
		model.addAttribute("password", password);
		
		String oldPass = uService.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName()).getPassword();
			
		uActual.getCliente().setEmail(uActual.getUsername());
		
		if (uService.encriptar(password).equals(oldPass) || password.length()==0) {
			
			uActual.setPassword(oldPass);
			uService.merge(uActual);	
		} else {
			
			uService.merge(uService.cambiarPassword(uActual, password));	
			
		}
				
		flash.addFlashAttribute("success", "Cambios guardados.");
		return "redirect:/home";		
	}
}
