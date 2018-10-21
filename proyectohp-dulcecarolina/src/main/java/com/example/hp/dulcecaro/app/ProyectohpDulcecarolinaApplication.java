package com.example.hp.dulcecaro.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class ProyectohpDulcecarolinaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ProyectohpDulcecarolinaApplication.class, args);
	}
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public void run(String... args) throws Exception {
		
		
	}
}
