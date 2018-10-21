package com.example.hp.dulcecaro.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.hp.dulcecaro.app.models.entity.Usuario;
import com.example.hp.dulcecaro.app.models.entity.UsuarioDTO;

public interface IUsuarioDao extends CrudRepository<Usuario, Long> {

	public Usuario findByUsername(String username);
	
	public void save(UsuarioDTO cuentaDTO);
}
