package com.example.hp.dulcecaro.app.models.service;

import java.util.List;

import com.example.hp.dulcecaro.app.models.entity.Producto;

public interface IProductoService {

	public List<Producto> findAll(); //simplemente se indica el nombre del metodo, sin implementar
	
	public void save(Producto producto);
	
	public Producto findOne(Long id);
	
	public void delete(Long id);
}
