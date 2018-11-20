package com.example.hp.dulcecaro.app.models.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.hp.dulcecaro.app.models.entity.Cliente;

//tambien puede ser: extends JpaRepository , que implementa mas cosas, como paginación de resultados.
public interface IClienteDao extends CrudRepository<Cliente, Long> {  //Long es el tipo de dato de la clave primaria de Cliente
	
}

//para implementar Crud repository, se elimina todo lo comentado. tambien se elimina la clase ClienteDaoImpl
//public interface IClienteDao {
//	
////esta interfaz contiene los metodos que tiene que implementar la clase ClienteDao
//	
//	public List<Cliente> findAll();
//	
//	public void save(Cliente cliente); //"contrato" de implementacion para guardar un nuevo cliente en la base de datos
//	
//	public Cliente findOne(Long id);
//	
//	public void delete(Long id);
//}
