package com.example.hp.dulcecaro.app.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="materias_prima")
public class MateriaPrima implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_mp")
	private Long id;
	
	@NotEmpty
	@Column(name="nom_mp")
	private String nom;
	
	@NotEmpty
	@Column(name="marca_mp")
	private String marca;
	
	@NotEmpty
	@Column(name="uni_med_mp")
	private String uniMed;
	
	
	@Column(name="cal_uni_med_mp")
	private double calUniMed;
	
	
	@Column(name="hdc_uni_med_mp")
	private double hdcUniMed;
	
	
	@Column(name="fib_uni_med_mp")
	private double fibUniMed;
	
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}


	public String getUniMed() {
		return uniMed;
	}


	public void setUniMed(String uniMed) {
		this.uniMed = uniMed;
	}


	public double getCalUniMed() {
		return calUniMed;
	}


	public void setCalUniMed(double calUniMed) {
		this.calUniMed = calUniMed;
	}


	public double getHdcUniMed() {
		return hdcUniMed;
	}


	public void setHdcUniMed(double hdcUniMed) {
		this.hdcUniMed = hdcUniMed;
	}


	public double getFibUniMed() {
		return fibUniMed;
	}


	public void setFibUniMed(double fibUniMed) {
		this.fibUniMed = fibUniMed;
	}


	
	
	
	private static final long serialVersionUID = 1L;

	
	
}
