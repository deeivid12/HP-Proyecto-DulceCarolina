package com.example.hp.dulcecaro.app.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "clientes") // esta linea se puede omitir cuando la tabla se llama igual que la clase
public class Cliente implements Serializable { // implementar Serializable es buena practica para MVC

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_cli")
	private Long id; // los ID no usar generacion automatica. hacer metodo propio de generacion

	// Uso @Column cuando nombre del atributo es distinto al nombre de la columna en
	// la base de datos.
	@Column(name = "nom_cli", insertable = true, updatable = true)
	@NotEmpty
	private String nom;

	@Column(name = "ape_cli", insertable = true, updatable = true)
	@NotEmpty
	private String ape;

	@Column(name = "email_cli", unique = true, updatable = true)
	@NotEmpty
	@Email
	private String email;

	@Column(name = "tel_cli", updatable = true)
	@NotEmpty
	private String tel;

	@Column(name = "dir_cli", updatable = true)
	@NotEmpty
	private String dir;
	
	//cascadetype all es para que si el cliente persiste/se elimina tambien lo hagan todos sus pedidos
	//en el mappedby se indica el nombre del atributo usado en la tabla dueña de la relacion
	@OneToMany(mappedBy="cliente",fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<Pedido> pedidos;
	
	/*
	 * @PrePersist public void prePersist() { createAt = new Date(); }
	 */

	public Cliente() {
		pedidos = new ArrayList<Pedido>();
	}

	public Long getId() {
		return id;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
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
	
	public void addPedido(Pedido pedido) {
		pedidos.add(pedido);
	}
}
