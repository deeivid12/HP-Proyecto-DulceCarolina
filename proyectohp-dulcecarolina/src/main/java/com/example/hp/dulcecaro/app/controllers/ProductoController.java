package com.example.hp.dulcecaro.app.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;

import com.example.hp.dulcecaro.app.models.entity.Producto;
import com.example.hp.dulcecaro.app.models.service.IProductoService;

@Controller
@SessionAttributes("producto") //en lugar de usar el campo id oculto en el form, se pueden usar variables de sesion
public class ProductoController {
	
	@Autowired
	private IProductoService productoService;
	
	@RequestMapping(value="/listarProductos", method=RequestMethod.GET)
	public String listarProductos(Model model) {
		model.addAttribute("titulo", "Listado de Productos");
		model.addAttribute("productos", productoService.findAll());
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
			producto = productoService.findOne(id);
		} else {
			return "redirect:/listarProductos";
		}
		model.put("producto", producto);
		model.put("titulo", "Editar Producto");
		return "formProducto";
	}
	
	@RequestMapping(value="/formProducto", method=RequestMethod.POST)
	public String guardar(@Valid Producto producto, BindingResult result, Model model,@RequestParam("file") MultipartFile imagen, SessionStatus status) {  //procesa el form
		
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de Producto");
			return "formProducto";
		}
		
		
		if (!imagen.isEmpty()) {
			
			String uniqueFilename = UUID.randomUUID().toString() + "_" + imagen.getOriginalFilename();
			Path rootPath = Paths.get("uploads").resolve(uniqueFilename);
			Path rootAbsolutPath = rootPath.toAbsolutePath();
			
			try {
				
				Files.copy(imagen.getInputStream(), rootAbsolutPath);
				producto.setImagen(uniqueFilename);
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		};
		
		productoService.save(producto);
		status.setComplete(); //elimina la sesion del producto
		return "redirect:listarProductos";
	}
	
	@RequestMapping(value="/eliminarProducto/{id}")
	public String eliminar(@PathVariable(value="id") Long id) {
		if (id > 0) {
			productoService.delete(id);
		}
		return "redirect:/listarProductos";		
	}

}
