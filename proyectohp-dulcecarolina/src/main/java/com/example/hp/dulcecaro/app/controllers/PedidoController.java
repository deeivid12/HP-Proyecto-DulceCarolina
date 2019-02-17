package com.example.hp.dulcecaro.app.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.hp.dulcecaro.app.models.entity.ItemPedido;
import com.example.hp.dulcecaro.app.models.entity.MateriaPrima;
import com.example.hp.dulcecaro.app.models.entity.Pedido;
import com.example.hp.dulcecaro.app.models.entity.Producto;
import com.example.hp.dulcecaro.app.models.service.IPedidoService;
import com.example.hp.dulcecaro.app.models.service.IProductoService;

@Controller
@RequestMapping("/pedido")
@SessionAttributes("pedido")
public class PedidoController {
	
	@Autowired
	private IProductoService productoService;
	
	@Autowired
	private IPedidoService pedidoService;
	
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
	
	@PostMapping("/formPedido")
	public String guardar(Pedido pedido,
			@RequestParam(name="item_id[]", required=false) Long[] itemId, 
			@RequestParam(name="cantidad[]", required=false) Integer[] cantidad,
			RedirectAttributes flash,
			SessionStatus status) {
		
		for(int i = 0; i < itemId.length; i++) {
			Producto producto = pedidoService.findProductoById(itemId[i]);
			
			ItemPedido linea = new ItemPedido();
			linea.setCantidad(cantidad[i]);
			linea.setProducto(producto);
			linea.setPedido(pedido);
			pedido.addProductoPedido(linea);
		}
		
		pedidoService.savePedido(pedido);
		status.setComplete(); //para finalaz el session attribute (notacion arriba)
		flash.addFlashAttribute("success", "Pedido creado con éxito!");
		return "redirect:/listarClientes";
	}
	
	@RequestMapping(value="/listarPedidos", method=RequestMethod.GET)
	public String listarPedidos(Model model) {
		
		List<Pedido> pedidos = pedidoService.findAll();
		List<Pedido> pedidosConcretados = new ArrayList<Pedido>();
		
		for (Pedido p : pedidos) {
		
			if(!p.getEstado().equals("NC")) {pedidosConcretados.add(p);}; //verifica que el pedido haya sido concretado! (NC=No concretado)
		}
	
		
		model.addAttribute("pedidos", pedidosConcretados);
		return "listarPedidos";
	}
	
	@RequestMapping(value="/detallePedido")
	public String crear(Map<String, Object> model) {
		
		Pedido pedido = new Pedido();
		model.put("pedido", pedido);
		model.put("titulo", "Formulario de Pedido");
		return "detallePedido";
	}
	
	
	
	@RequestMapping(value="/detallePedido/{id}")
	public String editar(@PathVariable(value="id") Long id,Map<String, Object> model) {
		Pedido pedido = null;
		List<ItemPedido> items = null;
		if (id > 0) {
			pedido = pedidoService.findOne(id);
			items = pedido.getProductos();
		} else {
			return "redirect:/pedido/listarPedidos";
		}
		model.put("pedido", pedido);
		model.put("items", items);
		model.put("titulo", "Pedido");
		return "detallePedido";
	}
	
	@RequestMapping(value="/detallePedido", method=RequestMethod.POST)
	public String guardar(@Valid Pedido pedido, BindingResult result, Model model, SessionStatus status) { //metodo que procesa el formulario
		 
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Pedido");
			return "detallePedido";
		}
		
		pedidoService.savePedido(pedido);
		status.setComplete(); //con esto se elimina el objeto mPrima de la sesion.
		return "redirect:/pedido/listarPedidos";
	}
		
	
}
