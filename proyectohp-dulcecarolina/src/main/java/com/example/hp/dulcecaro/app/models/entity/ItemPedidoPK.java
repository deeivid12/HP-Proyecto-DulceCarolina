package com.example.hp.dulcecaro.app.models.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class ItemPedidoPK implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Long id_pro;
	
	public ItemPedidoPK() {
		
	}
	
	public ItemPedidoPK(Long id, Long id_pro) {
		this.id = id;
		this.id_pro = id_pro;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getId_pro() {
		return id_pro;
	}
	public void setId_pro(Long id_pro) {
		this.id_pro = id_pro;
	}
	
	
	
}
