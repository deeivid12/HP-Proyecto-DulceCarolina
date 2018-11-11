package com.example.hp.dulcecaro.app.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="itemspedido")
public class ItemPedido implements Serializable {
	
	//Relacion agregada y necesaria para indicar que el id pedido forma parte de la PK del item
	@Id
	@ManyToOne(fetch=FetchType.LAZY)
	private Pedido pedido;
	
	@Id
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_pro") //para relacionar la tabla itemspedido con la tabla producto
	private Producto producto;
	
	@Column(name="can_ip")
	private Integer cantidad;
	
	@Column(name="imp_ip")
	private Double importe;
	
	public Double calcularImporte() {
		//return cantidad.doubleValue() * producto.GetPrecio();
		return cantidad.doubleValue() * producto.getPrecio();
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Double getImporte() {
		return importe;
	}

	public void setImporte(Double importe) {
		this.importe = importe;
	}
	
}
