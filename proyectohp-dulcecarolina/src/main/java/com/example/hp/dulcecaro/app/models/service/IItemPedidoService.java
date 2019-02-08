package com.example.hp.dulcecaro.app.models.service;
import com.example.hp.dulcecaro.app.models.entity.ItemPedido;


public interface IItemPedidoService {
	
	
	public void save(ItemPedido itemPedido);
	
	public ItemPedido findOne(Long id);
	
	public void delete(Long id);

}
