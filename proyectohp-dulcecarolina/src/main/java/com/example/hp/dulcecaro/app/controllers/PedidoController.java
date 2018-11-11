package com.example.hp.dulcecaro.app.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.example.hp.dulcecaro.app.models.entity.Pedido;
import com.example.hp.dulcecaro.app.models.entity.Producto;
import com.example.hp.dulcecaro.app.models.service.IProductoService;

@Controller
@RequestMapping("/pedido")
@SessionAttributes("pedido")
public class PedidoController {
	
	@Autowired
	private IProductoService productoService;
	
	@GetMapping("/formPedido")
//	public String crear(@PathVariable(value="clienteId") Long clienteId,
	public String crear(Map<String, Object> model, RedirectAttributes flash) {
		
//		Cliente cliente = clienteService.findOne(clienteId);
//		if (cliente==null) {
//			flash.addFlashAttribute("error", "Cliente inexistente.");
//			return "redirect:/listarClientes";
//		}
		
		Pedido pedido = new Pedido();
//		pedido.setCliente(cliente);
		
		model.put("pedido", pedido);
		model.put("titulo", "Crear Pedido");
		return "pedido/formPedido";
	}
	
	@GetMapping(value="/cargar-productos/{term}", produces= {"application/json"})
	public @ResponseBody List<Producto> cargarProductos(@PathVariable String term){  //respondebody lo que hace es suprimir el cargar una vista de thymeleaf
		return productoService.findByNombre(term); //retorna el resultado convertido a json
	}
}
