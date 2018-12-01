package com.example.hp.dulcecaro.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.hp.dulcecaro.app.models.dao.IPedidoDao;
import com.example.hp.dulcecaro.app.models.dao.IProductoDao;
import com.example.hp.dulcecaro.app.models.entity.Pedido;
import com.example.hp.dulcecaro.app.models.entity.Producto;

@Service
public class PedidoServiceImpl implements IPedidoService  {
	
	@Autowired
	private IPedidoDao pedidoDao;

	@Autowired
	private IProductoDao productoDao;
	
	@Override
	public List<Pedido> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Pedido pedido) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Pedido findOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public void savePedido(Pedido pedido) {
		// TODO Auto-generated method stub
		pedidoDao.save(pedido);
	}

	@Override
	public Producto findProductoById(Long id) {
		// TODO Auto-generated method stub
		return productoDao.findOne(id);
	}

}
