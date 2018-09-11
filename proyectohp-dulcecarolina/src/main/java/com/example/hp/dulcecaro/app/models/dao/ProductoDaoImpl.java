package com.example.hp.dulcecaro.app.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.hp.dulcecaro.app.models.entity.Producto;

@Repository //para mejorar la clase e indicarla  como componente persistente del sistema
public class ProductoDaoImpl implements IProductoDao {
	
	//el entitymanager se encarga de manejar las clases de entidades
	@PersistenceContext //el entitymanager implementa el datasource que este configurado, por defecto usa h2 que esta embebida en nuestra aplicacion
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	@Override
	public List<Producto> findAll() {
		// TODO Auto-generated method stub
		return em.createQuery("from Producto").getResultList(); //aca retorna el listado de productos
	}
	
	@Override
	@Transactional(readOnly=true)
	public Producto findOne(Long id) {
		// TODO Auto-generated method stub
		return em.find(Producto.class, id);
	}

	@Override
	@Transactional //sin readonly ya que es un metodo de escritura
	public void save(Producto producto) {
		// TODO Auto-generated method stub
		if (producto.getId() != null && producto.getId() > 0) {
			em.merge(producto);
		} else {
			em.persist(producto);
		}		
	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		//Producto producto = findOne(id);
		//em.remove(producto);
		em.remove(findOne(id));
	}

}
