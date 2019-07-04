package com.joselinex.polloloko.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Embeddable //no merece ser una Entity (nunca se crearán, eliminarán, modificarán independ.)
public class LineaPedido implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="id_producto")
	
	private Producto producto;
	private double precio;
	
	public LineaPedido() {
	}

	public LineaPedido(Long id, Producto producto, double precio) {
		this.id = id;
		this.producto = producto;
		this.precio = precio;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
		
}
