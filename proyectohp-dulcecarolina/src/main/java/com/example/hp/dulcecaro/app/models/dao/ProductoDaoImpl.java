/*
package com.example.hp.dulcecaro.app.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.example.hp.dulcecaro.app.models.entity.Producto;

@Repository //para mejorar la clase e indicarla  como componente persistente del sistema
public class ProductoDaoImpl implements IProductoDao {
	
	//el entitymanager se encarga de manejar las clases de entidades
	@PersistenceContext //el entitymanager implementa el datasource que este configurado, por defecto usa h2 que esta embebida en nuestra aplicacion
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Producto> findAll() {
		// TODO Auto-generated method stub
		return em.createQuery("from Producto").getResultList(); //aca retorna el listado de productos
	}
	
	@Override
	public Producto findOne(Long id) {
		// TODO Auto-generated method stub
		return em.find(Producto.class, id);
	}

	@Override
	public void save(Producto producto) {
		// TODO Auto-generated method stub
		if (producto.getId() != null && producto.getId() > 0) {
			em.merge(producto);
		} else {
			em.persist(producto);
		}		
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		//Producto producto = findOne(id);
		//em.remove(producto);
		em.remove(findOne(id));
	}

}
*/
