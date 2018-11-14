package com.example.hp.dulcecaro.app.models.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="clientes") //esta linea se puede omitir cuando la tabla se llama igual que la clase 
public class Cliente implements Serializable {  //implementar Serializable es buena practica para MVC
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id; //los ID no usar generacion automatica. hacer metodo propio de generacion
	
	//Uso @Column cuando nombre del atributo es distinto al nombre de la columna en la base de datos.
	@Column(name="nombre",insertable=true,updatable=true) 
	@NotEmpty
	private String nom;
	
	@Column(name="apellido",insertable=true,updatable=true)
	@NotEmpty
	private String ape;
	
	@Column(name="email",unique=true,updatable=true)
	//@NotEmpty
	@Email
	private String email;
	
	@Column(name="telefono",updatable=true)
	@NotEmpty
	private String tel;
	
	@Column(name="direccion",updatable=true)
	@NotEmpty
	private String dir;
	
	/* @PrePersist
	 * public void prePersist() {
	 * 	createAt = new Date();
	 * }
	 * */
	
	@OneToOne(mappedBy = "cliente") //PARA LA RELACION USUARIO-CLIENTE
	private Usuario usuario;
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
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
	public String getApe() {
		return ape;
	}
	public void setApe(String ape) {
		this.ape = ape;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getDir() {
		return dir;
	}
	public void setDir(String dir) {
		this.dir = dir;
	}
	
	
	
}
