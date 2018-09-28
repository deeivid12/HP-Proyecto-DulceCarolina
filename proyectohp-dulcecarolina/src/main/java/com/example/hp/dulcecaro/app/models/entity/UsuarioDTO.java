package com.example.hp.dulcecaro.app.models.entity;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class UsuarioDTO { //clase que transferira todos los datos del usuario
	
	
	@NotNull
	@NotEmpty
	private String username;
	
	@NotNull
	@NotEmpty
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

}
