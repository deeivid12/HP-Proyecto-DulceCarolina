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

import com.example.hp.dulcecaro.app.models.dao.ClienteDaoImpl;
import com.example.hp.dulcecaro.app.models.dao.IProductoDao;
import com.example.hp.dulcecaro.app.models.entity.Producto;

@Controller
@SessionAttributes("producto") //en lugar de usar el campo id oculto en el form, se pueden usar variables de sesion
public class ProductoController {
	
	@Autowired
	private IProductoDao productoDao;
	
	@RequestMapping(value="/listarProductos", method=RequestMethod.GET)
	public String listarProductos(Model model) {
		model.addAttribute("titulo", "Listado de Productos");
		model.addAttribute("productos", productoDao.findAll());
		return "listarProductos";
	}
	
	@RequestMapping(value="/formProducto")
	public String crear(Map<String, Object> model) {
		
		Producto producto = new Producto();
		model.put("producto", producto);
		model.put("titulo", "Formulario de Producto");
		return "formProducto";
	}
	
	@RequestMapping(value="/formProducto/{id}")
	public String editar(@PathVariable(value="id") Long id,Map<String, Object> model) {
		Producto producto = null;
		if (id > 0) {
			producto = productoDao.findOne(id);
		} else {
			return "redirect:/listarProductos";
		}
		model.put("producto", producto);
		model.put("titulo", "Editar Producto");
		return "formProducto";
	}
	
	@RequestMapping(value="/formProducto", method=RequestMethod.POST)
	public String guardar(@Valid Producto producto, BindingResult result, Model model, SessionStatus status) {  //procesa el form
		
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de Producto");
			return "formProducto";
		}
		
		productoDao.save(producto);
		status.setComplete(); //elimina la sesion del producto
		return "redirect:listarProductos";
	}
	
	@RequestMapping(value="/eliminarProducto/{id}")
	public String eliminar(@PathVariable(value="id") Long id) {
		if (id > 0) {
			productoDao.delete(id);
		}
		return "redirect:/listarProductos";		
	}

}
