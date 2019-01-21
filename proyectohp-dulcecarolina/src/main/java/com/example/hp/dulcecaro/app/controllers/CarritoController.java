package com.example.hp.dulcecaro.app.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.hp.dulcecaro.app.models.entity.ItemPedido;
import com.example.hp.dulcecaro.app.models.entity.Pedido;
import com.example.hp.dulcecaro.app.models.entity.ProdAJAX;
import com.example.hp.dulcecaro.app.models.entity.Producto;
import com.example.hp.dulcecaro.app.models.entity.Usuario;
import com.example.hp.dulcecaro.app.models.service.IPedidoService;
import com.example.hp.dulcecaro.app.models.service.IProductoService;
import com.example.hp.dulcecaro.app.models.service.UsuarioServiceImpl;

@Controller //marca y configura la clase como un controlador
@SessionAttributes("carrito") 
public class CarritoController {
	
	
	@Autowired
	private IProductoService productoService;
	
	@Autowired
	private IPedidoService pedidoService;
	
	@Autowired
	private UsuarioServiceImpl uService;
	
	@RequestMapping (value="/carroCompras", method=RequestMethod.GET)
	public String carroCompras(Map<String, Object> model) {
		
		
		Usuario uActual = new Usuario();
		
		//hardcodeo un pedido para el usuario actual
		
		Pedido p = new Pedido();
		Producto pro = new Producto();
		ItemPedido item = new ItemPedido();
		pro.setNom("Producto");
		pro.setDsc("Producto de prueba");
		item.setProducto(pro); //en item cargo producto
		item.setCantidad(1);//en item cargo cantidad de ese producto
		item.setImporte(100.00);
		
		
		List<ItemPedido> items = new ArrayList<ItemPedido>();
		items.add(item);//guardo item en lista de items. por ahora esto es lo que voy a mandar a la vista.
		p.setProductos(items);//guardo lista de items en pedido
		
		
		
		List<Pedido> pedidos = new ArrayList<Pedido>();
		pedidos.add(p);

		
		//LO IMPORTANTE ES QUE EN EL CLIENTE SE GUARDEN PEDIDOS, CARGAR EL PEDIDO EN CURSO Y QUE MUESTRE TODOS LOS ITEMS!
		
		
		uActual = uService.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
		uActual.getCliente().setPedidos(pedidos);
		model.put("items", items); //por ahora solo paso items para una prueba
		return "carroCompras"; 
	}
	
	@RequestMapping (value="/carrito", method=RequestMethod.GET)
	public String carrito(Map<String, Object> model) {
		 
		
		model.put("productos", productoService.findAll());
		
		return "carrito";
		
		
	}
		
	@PostMapping(value = "/carrito",
	        consumes = {"application/json", MediaType.APPLICATION_FORM_URLENCODED_VALUE}, 
	        produces = "application/json")
	        //produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody String confirmaCarrito(@RequestBody ProdAJAX prod) { //puede llevar @ResponseBody, si no funciona. idem con @RequestBody en ProdAJAX
        
		
		System.out.println("X: " + prod.getX()); //solo para probar que realmente se pasan datos con ajax
		System.out.println("Y: " + prod.getY());
		
		/* CON ESTO SE INTENTA CREAR UN PEDIDO! FALTAN DETALLES EN EL CONTROLADOR PEDIDOS
		
		ItemPedido itemPedido = new ItemPedido();
		
		Producto producto = productoService.findOne((long) 1);
		
		Pedido pedido = new Pedido();
		
		itemPedido.setProducto(producto);
		itemPedido.setCantidad(prod.getY());
		itemPedido.setImporte(10.00);
		
		pedido.addProductoPedido(itemPedido);
		
		
		Usuario uActual = new Usuario();
		uActual = uService.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
		uActual.getCliente().addPedido(pedido);
		
		pedido.setCliente(uActual.getCliente());
		
		pedidoService.save(pedido);
		
		*/
		
		return "";
    }
	
	@RequestMapping (value="/verPedido", method=RequestMethod.GET)
	public String verPedido(Map<String, Object> model) {
		 
		/* UNA VEZ SE CREO EL PEDIDO, CON ESTA PETICION SE CONFIRMA EL MISMO.
		
		Usuario uActual = new Usuario();
		uActual = uService.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
		List<Pedido> pedidos = new ArrayList<Pedido>();
		pedidos = uActual.getCliente().getPedidos();
		Pedido pedActual = new Pedido();
		List<ItemPedido> items = new ArrayList<ItemPedido>();
		
		pedActual = pedidos.get(pedidos.size());
		items = pedActual.getProductos();
		
		
		
		
		
		model.put("pedido", pedActual);
		model.put("items", items);
		
		
		*/
		
		return "verPedido";
		
		
	}

}
