package com.example.hp.dulcecaro.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception { //PARA VALIDAR PERMISOS!
		
		http.authorizeRequests().antMatchers("/", "/listar**", "/css/**", "/imagenes/**", "/js/**").permitAll() //RUTAS PUBLICAS!!
		.antMatchers("/form**/**").hasAnyRole("ADMIN")
		.anyRequest().authenticated()
		.and()
			.formLogin().loginPage("/login")
			.permitAll()
		.and()
		.logout().permitAll();
	}

	@Autowired
	public void configurerGlobal(AuthenticationManagerBuilder build) throws Exception { //build es el repo en donde se van a guardar los usuarios
		
		//ACA CONFIGURAR EL PASSWORD ENCODER + JPA!
	}

}
