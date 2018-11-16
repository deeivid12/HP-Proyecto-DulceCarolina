package com.example.hp.dulcecaro.app.models.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.hp.dulcecaro.app.models.entity.Usuario;

@Repository
public class UsuarioDaoCustomImpl implements IUsuarioDaoCustom {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public void merge(Usuario usuario) {
		em.merge(usuario);

	}
	
}
