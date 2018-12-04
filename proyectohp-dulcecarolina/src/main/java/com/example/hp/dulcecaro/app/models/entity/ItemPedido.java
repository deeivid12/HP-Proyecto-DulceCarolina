package com.example.hp.dulcecaro.app.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name="itemspedido")
public class ItemPedido implements Serializable {	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private ItemPedidoPK itemPedidoPK;
	
	@MapsId("id")
	@ManyToOne(fetch=FetchType.LAZY)
	private Pedido pedido;
	
	@MapsId("id_pro")
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

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
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
