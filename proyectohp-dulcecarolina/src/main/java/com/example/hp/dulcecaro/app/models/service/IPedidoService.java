package com.example.hp.dulcecaro.app.models.service;

import java.util.List;

import com.example.hp.dulcecaro.app.models.entity.Pedido;

public interface IPedidoService {
	
	public List<Pedido> findAll();
	public void save(Pedido pedido);
	public Pedido findOne(Long id);
	public void delete(Long id);
}
