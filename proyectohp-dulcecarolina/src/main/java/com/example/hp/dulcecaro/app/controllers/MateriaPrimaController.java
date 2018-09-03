package com.example.hp.dulcecaro.app.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.hp.dulcecaro.app.models.dao.IMateriaPrimaDao;
import com.example.hp.dulcecaro.app.models.entity.MateriaPrima;

@Controller
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
		return "formMateriaPrima"; // nombre de la vista
	} 
	
	@RequestMapping(value="/formMateriaPrima", method=RequestMethod.POST)
	public String guardar(@Valid MateriaPrima mPrima, BindingResult result, Model model) { //metodo que procesa el formulario
		
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de Materias Prima");
			return "formMateriaPrima";
		}
		
		mPrimaDao.save(mPrima);
		return "redirect:listarMateriasPrima";
	}
	
}
	
