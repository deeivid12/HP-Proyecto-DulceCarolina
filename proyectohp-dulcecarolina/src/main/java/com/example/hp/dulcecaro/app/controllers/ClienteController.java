package com.example.hp.dulcecaro.app.controllers;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.example.hp.dulcecaro.app.models.entity.Cliente;
import com.example.hp.dulcecaro.app.models.service.IClienteService;

@Controller //marca y configura la clase como un controlador
@SessionAttributes("cliente") 
public class ClienteController {

	@Autowired //con esta notacion va a buscar un componente registrado en el contenedor que implemente la interface ICLienteDao
	private IClienteService clienteService; //atributo de clienteDao para poder realizar la consulta. Siempre se usa el tipo mas generico, en este caso de la interface
	
	@RequestMapping(value="/listarClientes", method=RequestMethod.GET)  // indicar html
	public String listar(Model model) { //clase model para pasar datos a la vista
	
		model.addAttribute("titulo", "Listado de clientes");  //para pasar atributo a la vista
		model.addAttribute("clientes", clienteService.findAll()); //para pasar atributo a la vista
		
		return "listarClientes";  //retornamos el nombre de la vista, debe coincidir con nombre del html donde muestro
	}
	
	
	@RequestMapping(value="/formCliente")
	public String crear(Map<String, Object> model) {   //recibe objeto model para pasar datos a la vista. 
		                                               //Puede ser tipo Model como arriba o Map como en este caso
		Cliente cliente = new Cliente(); //este obj esta mapeado a la tabla de la BD y al formulario. Es un obj de negocio bidireccional
		model.put("cliente", cliente);
		model.put("titulo", "Formulario de Cliente");
		return "formCliente";
	//primera fase: mostrar el formulario al usuario
	}

	
	@RequestMapping(value="/formCliente", method=RequestMethod.POST)
	public String guardar(@Valid Cliente cliente, BindingResult result, Model model, SessionStatus status) { //metodo que procesa el formulario
		
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de Cliente");
			return "formCliente";
		}
		
		clienteService.save(cliente);
		status.setComplete(); //elimina el objeto cliente de la sesión.
		return "redirect:listarClientes";
	}
	
	@RequestMapping(value="/formCliente/{id}")
	public String editar(@PathVariable(value="id") Long id, Map<String, Object> model) { 
		Cliente cliente = null;
		if(id > 0) {
			cliente = clienteService.findOne(id);
		} else {
			return "redirect:/listarClientes";
		}
		model.put("cliente", cliente);
		model.put("titulo", "Editar cliente");
		return "formCliente";
	}
	
	@RequestMapping(value="eliminarCliente/{id}")
	public String eliminar(@PathVariable(value="id") Long id) {
		if(id > 0) {
			clienteService.delete(id);
		} 
		return "redirect:/listarClientes";
	}
	
}
