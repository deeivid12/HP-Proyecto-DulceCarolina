package com.example.hp.dulcecaro.app.models.service;

import java.util.List;

import com.example.hp.dulcecaro.app.models.entity.Cliente;

public interface IClienteService 
{
	public List<Cliente> findAll();

	public void save(Cliente cliente); // "contrato" de implementacion para guardar un nuevo cliente en la base de datos

	public Cliente findOne(Long id);

	public void delete(Long id);
}
