package com.example.hp.dulcecaro.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.hp.dulcecaro.app.models.dao.IProductoDao;
import com.example.hp.dulcecaro.app.models.entity.Producto;

@Service //Clase basada en el patron de diseño Facade (Fachada). Un service puede tener diferentes Daos. Se lo toma como unico punto de acceso
public class ProductoServiceImpl implements IProductoService{
	
	@Autowired
	private IProductoDao productoDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<Producto> findAll() {
		// TODO Auto-generated method stub
		return productoDao.findAll();
	}

	@Override
	@Transactional //sin readonly ya que es un metodo de escritura
	public void save(Producto producto) {
		productoDao.save(producto);
	}

	@Override
	@Transactional(readOnly=true)
	public Producto findOne(Long id) {
		// TODO Auto-generated method stub
		return productoDao.findOne(id);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		productoDao.delete(id);
	}

	
}
