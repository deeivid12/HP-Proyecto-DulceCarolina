package com.example.hp.dulcecaro.app.models.service;

import com.example.hp.dulcecaro.app.models.entity.Usuario;
import com.example.hp.dulcecaro.app.models.entity.UsuarioDTO;
import com.example.hp.dulcecaro.app.validations.UsuarioExisteException;

public interface IUsuarioService {
	
	Usuario registrarNuevoUsuario(UsuarioDTO cuentaDTO) throws UsuarioExisteException;
	
	public void delete(Long id);
	
	public Usuario findByUsername(String username);
	
	//despues hay que manejar error de mail

}
