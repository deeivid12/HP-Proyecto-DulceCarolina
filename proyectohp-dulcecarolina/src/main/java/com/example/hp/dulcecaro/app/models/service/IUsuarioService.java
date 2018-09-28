package com.example.hp.dulcecaro.app.models.service;

import com.example.hp.dulcecaro.app.models.entity.Usuario;
import com.example.hp.dulcecaro.app.models.entity.UsuarioDTO;

public interface IUsuarioService {
	
	Usuario registrarNuevoUsuario(UsuarioDTO cuentaDTO);
	
	//despues hay que manejar error de mail

}
