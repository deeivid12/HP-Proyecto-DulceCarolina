package com.example.hp.dulcecaro.app.controllers;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.hp.dulcecaro.app.models.dao.IProductoDao;
import com.example.hp.dulcecaro.app.models.entity.Producto;

@Controller
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
	
	@RequestMapping(value="/formProducto", method=RequestMethod.POST)
	public String guardar(@Valid Producto producto, BindingResult result, Model model) {  //procesa el form
		
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de Producto");
			return "formProducto";
		}
		
		productoDao.save(producto);
		return "redirect:listarProductos";
	}

}
