package com.example.hp.dulcecaro.app.models.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="pedidos")
public class Pedido {
	
	@Id
	@Column(name="id_ped")
	private Long id;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Column(name="fec_rea_ped")
	private Date fecEmi;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Column(name="fec_ent_ped")
	private Date fecEnt;
	
	@Column(name="imp_ped")
	private Double importe;
	
	@Column(name="est_ped")
	private String estado;
	
	//fetchtype lazy es para que cuando se pidan los datos de un pedido no se cargue el cliente, sino recien cuando se lo invoque
	//de este modo se evita una sobrecarga de la base de datos (si es que son muchos pedidos por ejemplo)
	@ManyToOne(fetch=FetchType.LAZY) //many se refiere a la clase en la cual estamos. Pedido puede tener un solo cliente.
	@JoinColumn(name="id_cli")
	private Cliente cliente;
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="id_ped") //importantisimo generar la llave foranea id_ped en la tabla pedidoproductos
	private List<ItemPedido> productos;
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<ItemPedido> getProductos() {
		return productos;
	}

	public void setProductos(List<ItemPedido> productos) {
		this.productos = productos;
	}	
	
	public Pedido() {
		this.productos = new ArrayList<ItemPedido>();
	}

	@PrePersist //para que justo antes de persistir el pedido se asigne la fecha de creacion
	public void prePersist() { //este metodo se encarga de generar la fecha
		fecEmi = new Date();
		estado = "P"; //Pendiente
	}
	
	@Column(name="obs_ped")
	private String observacion;
	
	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFecRea() {
		return fecEmi;
	}

	public void setFecRea(Date fecRea) {
		this.fecEmi = fecRea;
	}

	public Date getFecEnt() {
		return fecEnt;
	}

	public void setFecEnt(Date fecEnt) {
		this.fecEnt = fecEnt;
	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(Double importe) {
		this.importe = importe;
	}
	
	public void addProductoPedido(ItemPedido producto) {
		this.productos.add(producto);
	}
	/*
	public Long getId_cli() {
		return id_cli;
	}

	public void setId_cli(Long id_cli) {
		this.id_cli = id_cli;
	}
	*/
	
	public Double getTotal() {
		Double total = 0.0;
		int size = productos.size();
		
		for(int i=0; i<size; i++) {
			total += productos.get(i).calcularImporte();
		}
		return total;
	}
}
