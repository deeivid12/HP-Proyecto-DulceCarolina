package com.example.hp.dulcecaro.app.models.entity;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;

//Serializable no obligatorio pero es una buena practica para traajar en mvc con jpa
@Entity
@Table(name="productos") //se puede omitir cuando la tabla se llama igual a la clase
public class Producto implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_pro")
	private Long id;
	
	@NotEmpty
	@Column(name="tipo_pro")
	private String tipo;
	
	@NotEmpty
	@Column(name="nom_pro")
	private String nom;
	
	@Column(name="dsc_pro")
	private String dsc;
	
	@Min(1)
	@Column(name="can_por_pro")
	private Long canPor;
	
	@Column(name="cal_porc_pro")
	private Double calPorPorc;
	
	@Column(name="hdc_porc_pro")
	private Double hdcPorPorc;
	
	@Column(name="fib_porc_pro")
	private Double fibPorPorc;
	
	@Column(name = "pre_pro")
	private Double precio;
	
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
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
	public Long getCanPor() {
		return canPor;
	}
	public void setCanPor(Long canPor) {
		this.canPor = canPor;
	}
	public double getCalPorPorc() {
		return calPorPorc;
	}
	public void setCalPorPorc(Double calPorPorc) {
		this.calPorPorc = calPorPorc;
	}
	public double getHdcPorPorc() {
		return hdcPorPorc;
	}
	public void setHdcPorPorc(Double hdcPorPorc) {
		this.hdcPorPorc = hdcPorPorc;
	}
	public double getFibPorPorc() {
		return fibPorPorc;
	}
	public void setFibPorPorc(Double fibPorPorc) {
		this.fibPorPorc = fibPorPorc;
	}
}
