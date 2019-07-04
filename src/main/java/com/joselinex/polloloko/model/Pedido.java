package com.joselinex.polloloko.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OrderColumn;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="pedidos")
public class Pedido implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@TableGenerator(name = "PEDIDO_GENERATOR",
					table = "SECUENCIAS",
					pkColumnName = "SEQ:NAME",
					pkColumnValue = "PEDIDO_SEQ",
					valueColumnName = "SEQ_NUMBER",
					allocationSize = 10)
	@GeneratedValue(strategy = GenerationType.TABLE,
					generator = "PEDIDO_GENERATOR")
	private Long id;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;
	
	private int mesa;
	
	//Mapeamos una clase: 
	//La relacion con la tabla camareros es ManyToOne => diferentes pedidos a un solo camarero.
	@ManyToOne
	@JoinColumn(name="ID_CAMARERO")
	private Camarero camarero;

	@ElementCollection
	@OrderColumn(name="INDICE")
	@CollectionTable(name="LINEAS_PEDIDO",
				joinColumns=@JoinColumn(name="ID_PEDIDO"))
	private List<LineaPedido> lineasPedido;

	public Pedido() {
	}

	public Pedido(Long id, Date fecha, int mesa, Camarero camarero, List<LineaPedido> lineasPedido) {
		this.id = id;
		this.fecha = fecha;
		this.mesa = mesa;
		this.camarero = camarero;
		this.lineasPedido = lineasPedido;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getMesa() {
		return mesa;
	}

	public void setMesa(int mesa) {
		this.mesa = mesa;
	}

	public Camarero getCamarero() {
		return camarero;
	}

	public void setCamarero(Camarero camarero) {
		this.camarero = camarero;
	}

	public List<LineaPedido> getLineasPedido() {
		return lineasPedido;
	}

	public void setLineasPedido(List<LineaPedido> lineasPedido) {
		this.lineasPedido = lineasPedido;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", fecha=" + fecha + ", mesa=" + mesa + ", camarero=" + camarero + ", lineasPedido="
				+ lineasPedido + "]";
	}	
	
	
}