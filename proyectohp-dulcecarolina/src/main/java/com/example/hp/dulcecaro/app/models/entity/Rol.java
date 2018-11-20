/*package com.example.hp.dulcecaro.app.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "roles") // "authorities"
public class Rol implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String authority; // nombre del rol

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public void setAuthorityUser() {
		this.authority = "ROLE_USER";
	}
	
	public void setAuthorityAdmin() {
		this.authority = "ROLE_ADMIN";
	}
	
	private static final long serialVersionUID = 1L;

} */

package com.example.hp.dulcecaro.app.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "roles", uniqueConstraints= {@UniqueConstraint(columnNames= {"usuario_id", "authority"})}) // "authorities"
public class Rol implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String authority; // nombre del rol

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public void setAuthorityUser() {
		this.authority = "ROLE_USER";
	}
	
	public void setAuthorityAdmin() {
		this.authority = "ROLE_ADMIN";
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
