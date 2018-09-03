package com.example.hp.dulcecaro.app.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

//Serializable no obligatorio pero es una buena practica para traajar en mvc con jpa
@Entity
@Table(name="productos") //se puede omitir cuando la tabla se llama igual a la clase
public class Producto implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id;
	
	//@Column se utiliza cuando los nombres de los atributos en las clases difieren de los de la tabla
	
	@NotEmpty
	private String tipo;
	
	@NotEmpty
	private String nom;
	
	private String dsc;
	
	@NotEmpty
	private String canPor;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDsc() {
		return dsc;
	}
	public void setDsc(String dsc) {
		this.dsc = dsc;
	}
	public String getCanPor() {
		return canPor;
	}
	public void setCanPor(String canPor) {
		this.canPor = canPor;
	}
}
