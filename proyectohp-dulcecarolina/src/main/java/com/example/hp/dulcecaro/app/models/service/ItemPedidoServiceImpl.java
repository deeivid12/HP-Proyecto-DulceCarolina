package com.example.hp.dulcecaro.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.hp.dulcecaro.app.models.dao.IItemPedidoDao;
import com.example.hp.dulcecaro.app.models.dao.IPedidoDao;
import com.example.hp.dulcecaro.app.models.dao.IProductoDao;
import com.example.hp.dulcecaro.app.models.entity.ItemPedido;
import com.example.hp.dulcecaro.app.models.entity.Pedido;
import com.example.hp.dulcecaro.app.models.entity.Producto;

@Service
public class ItemPedidoServiceImpl implements IItemPedidoService  {

	@Autowired
	private IItemPedidoDao itemPedidoDao;
	
	
	@Override
	@Transactional
	public void save(ItemPedido itemPedido) {
		// TODO Auto-generated method stub
		
		itemPedidoDao.save(itemPedido);
	}

	@Override
	public ItemPedido findOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}
	
	

}
