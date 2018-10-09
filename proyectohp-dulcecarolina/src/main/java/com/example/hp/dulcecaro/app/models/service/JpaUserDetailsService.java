package com.example.hp.dulcecaro.app.models.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.hp.dulcecaro.app.models.dao.IUsuarioDao;
import com.example.hp.dulcecaro.app.models.entity.Rol;
import com.example.hp.dulcecaro.app.models.entity.Usuario;

@Service("jpaUserDetailsService")
public class JpaUserDetailsService implements UserDetailsService {
	
	@Autowired
	private IUsuarioDao usuarioDao;
	
	private Logger logger = LoggerFactory.getLogger(JpaUserDetailsService.class);

	@Override
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Usuario usuario = usuarioDao.findByUsername(username);
		
		if(usuario == null) {
			logger.error("No existe usuario");
			throw new UsernameNotFoundException("No existe usuario");
		}
		
		//obtener todos sus roles!
		List<GrantedAuthority> listaRoles = new ArrayList<GrantedAuthority>();
		for(Rol rol : usuario.getRoles()) {
			
			listaRoles.add(new SimpleGrantedAuthority(rol.getAuthority()));
		}
		
		
		return new User(usuario.getUsername(), usuario.getPassword(), usuario.getEnabled(), true, true, true, listaRoles);
	}

}
