package generation.javongus.html.model;


import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "carrito")
public class Carrito {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name="id", unique = true, nullable = false) 
	private Long id;
	
	@OneToMany(mappedBy = "carrito")
	private List<CarritoProducto> carritoProducto;

//	Constructores
	public Carrito() {
		super();
	}

	public Carrito(Long id, List<CarritoProducto> carritoProducto) {
		super();
		this.id = id;
		this.carritoProducto = carritoProducto;
	}
//	Getter and Setter
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<CarritoProducto> getCarritoProducto() {
		return carritoProducto;
	}

	public void setCarritoProducto(List<CarritoProducto> carritoProducto) {
		this.carritoProducto = carritoProducto;
	}
	
	
}
