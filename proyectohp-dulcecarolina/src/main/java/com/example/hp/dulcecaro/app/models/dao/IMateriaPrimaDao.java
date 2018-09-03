package com.example.hp.dulcecaro.app.models.dao;

import java.util.List;

import com.example.hp.dulcecaro.app.models.entity.MateriaPrima;

public interface IMateriaPrimaDao {
	
	public List<MateriaPrima> findAll();
	
	public void save(MateriaPrima mPrima);
	
	/*public MateriaPrima findOne(Long id);
	
	public void delete (long id); */


}
