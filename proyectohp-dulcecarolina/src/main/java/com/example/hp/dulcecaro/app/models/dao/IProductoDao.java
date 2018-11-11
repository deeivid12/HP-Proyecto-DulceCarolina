package com.example.hp.dulcecaro.app.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.hp.dulcecaro.app.models.entity.Producto;

public interface IProductoDao extends CrudRepository<Producto, Long>{
	
	/* - Comentado porque se paso a implementar el crudrepository
	public List<Producto> findAll(); //simplemente se indica el nombre del metodo, sin implementar
	
	public void save(Producto producto);
	
	public Producto findOne(Long id);
	
	public void delete(Long id);
	*/
	
	@Query("select p from Producto p where p.nom like %?1%") //consulta a nivel de objeto, no de tabla. ?1 = term
	public List<Producto> findByNombre(String term);
	
	public List<Producto> findByNomLikeIgnoreCase(String term);
}
