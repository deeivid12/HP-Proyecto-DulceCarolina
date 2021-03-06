package com.example.hp.dulcecaro.app.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.hp.dulcecaro.app.models.entity.MateriaPrima;

@Repository
public class MateriaPrimaDaoImpl implements IMateriaPrimaDao {
	
	
	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly=true)
	public List<MateriaPrima> findAll() {
		return em.createQuery("from MateriaPrima").getResultList(); // el from se hace siempre hacia la CLASE, NUNCA HACIA LA TABLA!!
			}

	@Override
	@Transactional
	public void save(MateriaPrima mPrima) {
		//el objeto mPrima forma parte del contexto de persistencia. Por lo tanto 
		//es manejado por jpa, queda "atachado" al contexto
		
		if(mPrima.getId() != null && mPrima.getId() > 0) {
			em.merge(mPrima);
		}else {
			em.persist(mPrima); //toma el objeto mPrima y lo guarda dentro del contexto de persistencia, dentro del contexto jpa
		}
	}
	

	@Transactional(readOnly=true)
	@Override
	public MateriaPrima findOne(Long id) {
		
		return em.find(MateriaPrima.class, id); //se le pasa el id de la materia prima para poder recuperarlo.
	}

	@Transactional
	@Override
	public void delete(long id) {
		
		MateriaPrima mPrima = findOne(id);
		em.remove(mPrima);
		
	} 

}
