package com.example.hp.dulcecaro.app.models.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.hp.dulcecaro.app.models.entity.Rol;

@Repository
public class RolDaoImpl implements IRolDao {
	

	@PersistenceContext
	private EntityManager em;
	
	@Override
	@Transactional
	public void save(Rol rol) {
		
		if(rol.getId() != null && rol.getId() > 0) {
			em.merge(rol);			
		} else {
			em.persist(rol);
		}
		
	}

}
