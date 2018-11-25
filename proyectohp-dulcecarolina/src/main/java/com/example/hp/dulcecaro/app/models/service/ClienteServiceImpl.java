package com.example.hp.dulcecaro.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.hp.dulcecaro.app.models.dao.IClienteDao;
import com.example.hp.dulcecaro.app.models.entity.Cliente;

@Service
public class ClienteServiceImpl implements IClienteService {
//por cada método en la clase Dao, vamos a tener metodos en el CLienteService
//se podrian tener diferentes Dao y dentro del Service acceder a los distintos Dao como un unico punto de acceso.
//otra caracteristica: esta clase puede manejar la transaccion sin tener que implementar las anotaciones Transactional en el Dao.
	//dentro de un metodo en la clase Service, se podria interactuar con diferentes Dao y todo dentro de la misma transacción.
	@Autowired
	private IClienteDao clienteDao; 
	
	@Override
	@Transactional(readOnly=true)
	public List<Cliente> findAll() {
		return (List<Cliente>) clienteDao.findAll();
	}

	@Override
	@Transactional //no va readOnly=true porque esto es escritura, para insertar un registro
	public void save(Cliente cliente) {
		clienteDao.save(cliente);
	}

	@Override
	@Transactional(readOnly = true)
	public Cliente findOne(Long id) {
		clienteDao.findOne(id);
		return null;
	}

	@Override
	@Transactional
	public void delete(Long id) {
		clienteDao.delete(id);
		
	}

}
