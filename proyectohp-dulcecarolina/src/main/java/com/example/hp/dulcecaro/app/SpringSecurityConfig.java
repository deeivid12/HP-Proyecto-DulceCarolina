package com.example.hp.dulcecaro.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.hp.dulcecaro.app.models.service.JpaUserDetailsService;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	@Autowired
	private JpaUserDetailsService userDetailsService;
	
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception { //PARA VALIDAR PERMISOS!
		
		//PARA HABILITAR CONSOLA H2 CON SPRING SECURITY
		http.csrf().disable();
        http.headers().frameOptions().disable();
		
		http.authorizeRequests().antMatchers("/formMateriaPrima/**").hasAnyRole("ADMIN")
		.antMatchers("/", "/listar**", "/css/**", "/imagenes/**", "/js/**", "/h2-console/**", "/form**/**", "/registro").permitAll() //RUTAS PUBLICAS!!
		.anyRequest().authenticated()
		.and()
			.formLogin().loginPage("/login")
			.permitAll()
		.and()
		.logout().permitAll()
		.and()
		.exceptionHandling().accessDeniedPage("/error_403");
		
		
	}

	@Autowired
	public void configurerGlobal(AuthenticationManagerBuilder build) throws Exception { //build es el repo en donde se van a guardar los usuarios
		
		build.userDetailsService(userDetailsService)
		.passwordEncoder(passwordEncoder);
		
		//ACA CONFIGURAR EL PASSWORD ENCODER + JPA!
	}

}
