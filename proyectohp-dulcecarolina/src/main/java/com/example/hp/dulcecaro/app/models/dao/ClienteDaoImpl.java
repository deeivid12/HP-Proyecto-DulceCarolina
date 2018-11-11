package com.example.hp.dulcecaro.app.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.hp.dulcecaro.app.models.entity.Cliente;

@Repository
public class ClienteDaoImpl implements IClienteDao {

	@PersistenceContext
	private EntityManager em; //se encarga de manejar las clases de entidades
	
//	@SuppressWarnings("unchecked")
//	@Transactional(readOnly=true)
//	@Override
//	public List<Cliente> findAll() {
//		// TODO Auto-generated method stub
//		return em.createQuery("from Cliente").getResultList();
//	}
//
//	@Override
//	@Transactional(readOnly = true)
//	public Cliente findOne(Long id) {
//		return em.find(Cliente.class, id);
//	}
//	
//	@Override
//	@Transactional //no va readOnly=true porque esto es escritura, para insertar un registro
//	public void save(Cliente cliente) {
//		//el objeto cliente forma parte del contexto de persistencia. Por lo tanto 
//		//es manejado por jpa, queda "atachado" al contexto
//		
//		if(cliente.getId() != null && cliente.getId() >0) {
//			em.merge(cliente);  //atacha al contexto y lo actualiza
//		} else {
//			em.persist(cliente); //toma el objeto cliente y lo guarda dentro del contexto de persistencia, dentro del contexto jpa
//		}
//	}
//
//	@Override
//	@Transactional
//	public void delete(Long id) {
//		em.remove(findOne(id));  //encuentra al cliente y luego lo elimina
//	}

}
