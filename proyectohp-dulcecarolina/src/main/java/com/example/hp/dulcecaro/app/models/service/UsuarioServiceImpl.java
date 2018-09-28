package com.example.hp.dulcecaro.app.models.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import com.example.hp.dulcecaro.app.models.dao.IUsuarioDao;
import com.example.hp.dulcecaro.app.models.entity.Rol;
import com.example.hp.dulcecaro.app.models.entity.Usuario;
import com.example.hp.dulcecaro.app.models.entity.UsuarioDTO;

@Service("usuarioServiceImpl")
public class UsuarioServiceImpl implements IUsuarioService {

	@Autowired
	private IUsuarioDao usuarioDao;
	
	@Override
	public Usuario registrarNuevoUsuario(UsuarioDTO cuentaDTO) {
		
		
		Usuario usuario = new Usuario();
		Rol rol = new Rol();
		rol.setAuthorityUser();//para que por defecto sea ROLE_USER
		
		usuario.setUsername(cuentaDTO.getUsername());
		usuario.setPassword(cuentaDTO.getPassword());
		usuario.setRoles(Arrays.asList(rol));
		
		return usuarioDao.save(usuario);
		
		
		
	}

}
