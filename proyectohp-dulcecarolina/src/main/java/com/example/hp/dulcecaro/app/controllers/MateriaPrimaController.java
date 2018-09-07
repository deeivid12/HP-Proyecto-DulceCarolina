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

import com.example.hp.dulcecaro.app.models.dao.IMateriaPrimaDao;
import com.example.hp.dulcecaro.app.models.entity.MateriaPrima;

@Controller
@SessionAttributes("mPrima") //cada vez que se ejecuta Crear o Editar (peticion get), guarda la mPrima en la sesion y la pasa a la vista
public class MateriaPrimaController {
	
	@Autowired
	private IMateriaPrimaDao mPrimaDao;

	@RequestMapping(value="/listarMateriasPrima", method=RequestMethod.GET)
	public String listar(Model model) {
		
		//cargarProd();
		//model.addAttribute("productoObjeto", prodPrueba);
		
		model.addAttribute("titulo", "Listado de Materias Prima");
		model.addAttribute("mPrimas", mPrimaDao.findAll());
		return "listarMateriasPrima";
	}
	
	@RequestMapping(value="/formMateriaPrima")
	public String crear(Model model) { // Map<String,Object> es similar a Model, solo se muestra de otra
														// forma.
		MateriaPrima mPrima = new MateriaPrima(); // aca se pasaran los datos del formulario
		model.addAttribute("mPrima", mPrima);
		model.addAttribute("titulo", "Formulario de Materias Prima");
		model.addAttribute("boton", "Crear Materia prima");
		return "formMateriaPrima"; // nombre de la vista
	} 
	
	@RequestMapping(value="/formMateriaPrima/{id}")
	public String editar(@PathVariable(value="id") Long id, Map<String,Object> model){
		
		MateriaPrima mPrima = null;
		if(id>0) {
			mPrima = mPrimaDao.findOne(id);
			}
		else {
			return "redirect:/listarMateriasPrima";
		}
		
		model.put("mPrima", mPrima);
		model.put("titulo", "Editar Materia Prima");
		model.put("boton", "Actualizar Materia prima");
		return "formMateriaPrima";
		
	}
	
	@RequestMapping(value="/formMateriaPrima", method=RequestMethod.POST)
	public String guardar(@Valid MateriaPrima mPrima, BindingResult result, Model model, SessionStatus status) { //metodo que procesa el formulario
		 
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de Materias Prima");
			return "formMateriaPrima";
		}
		
		mPrimaDao.save(mPrima);
		status.setComplete(); //con esto se elimina el objeto mPrima de la sesion.
		return "redirect:/listarMateriasPrima";
	}
	
	@RequestMapping(value="/eliminarMateriaPrima/{id}")
	public String eliminar(@PathVariable(value="id") Long id, Map<String,Object> model){
		
		mPrimaDao.delete(id);
		model.put("boton", "Eliminar Materia Prima");
		return "redirect:/listarMateriasPrima"; 
		
	}
	
}
	
