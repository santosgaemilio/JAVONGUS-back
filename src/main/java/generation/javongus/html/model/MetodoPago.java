package generation.javongus.html.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "metodo_pago")
public class MetodoPago {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name="id", unique = true, nullable = false) 
	private Long id;
	private String name;
	private String detalles;
	
	@OneToMany(mappedBy = "metodo", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private List<Carrito> carrito;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario_id")
	@JsonIgnore
	private Usuario usuario;

	public MetodoPago() {
		super();
	}

	public MetodoPago(Long id, String name, String detalles, List<Carrito> carrito, Usuario usuario) {
		super();
		this.id = id;
		this.name = name;
		this.detalles = detalles;
		this.carrito = carrito;
		this.usuario = usuario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDetalles() {
		return detalles;
	}

	public void setDetalles(String detalles) {
		this.detalles = detalles;
	}

	public List<Carrito> getCarrito() {
		return carrito;
	}

	public void setCarrito(List<Carrito> carrito) {
		this.carrito = carrito;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	
}
