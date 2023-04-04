package generation.javongus.html.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "carrito_producto")
public class CarritoProducto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name="id", unique = true, nullable = false) 
	private Long id;
	
	 @ManyToOne
	 @JoinColumn(name = "carrito_id")
	 @JsonIgnore
	 private Carrito carrito;
	 @ManyToOne
	 @JoinColumn(name = "producto_id")
//	 @JsonIgnore
	 private Producto producto;
	    
	 private Integer cantidad;

	public CarritoProducto() {
		
	}

	public CarritoProducto(Long id, Carrito carrito, Producto producto, Integer cantidad) {
		
		this.id = id;
		this.carrito = carrito;
		this.producto = producto;
		this.cantidad = cantidad;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Carrito getCarrito() {
		return carrito;
	}

	public void setCarrito(Carrito carrito) {
		this.carrito = carrito;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	 
	
}
