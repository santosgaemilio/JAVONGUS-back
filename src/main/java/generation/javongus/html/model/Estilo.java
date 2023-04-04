package generation.javongus.html.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "estilos")
public class Estilo {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name="id", unique = true, nullable = false) 
	 private Long id;
	 private String hexa;
	 private String imagen_back;
	 private String imagen_front;
	 private String imagen_left;
	 private String imagen_right;
	 
	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name = "producto_id")
	 @JsonIgnore
	 private Producto producto;

//	 CONSTRUCTORES
	 public Estilo() {}
	 
	 //	 completo sin producto ni opcionales
	 public Estilo(Long id, String hexa, String imagen_back, String imagen_front) {
			super();
			this.id = id;
			this.hexa = hexa;
			this.imagen_back = imagen_back;
			this.imagen_front = imagen_front;
		}
	 
	//	 completo sin producto
	 public Estilo(Long id, String hexa, String imagen_back, String imagen_front, String imagen_left,
				String imagen_right) {
			super();
			this.id = id;
			this.hexa = hexa;
			this.imagen_back = imagen_back;
			this.imagen_front = imagen_front;
			this.imagen_left = imagen_left;
			this.imagen_right = imagen_right;
		}
	 
	//	 completo con producto
	public Estilo(Long id, String hexa, String imagen_back, String imagen_front, String imagen_left,
			String imagen_right, Producto producto) {
		super();
		this.id = id;
		this.hexa = hexa;
		this.imagen_back = imagen_back;
		this.imagen_front = imagen_front;
		this.imagen_left = imagen_left;
		this.imagen_right = imagen_right;
		this.producto = producto;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getHexa() {
		return hexa;
	}
	public void setHexa(String hexa) {
		this.hexa = hexa;
	}
	public String getImagen_back() {
		return imagen_back;
	}
	public void setImagen_back(String imagen_back) {
		this.imagen_back = imagen_back;
	}
	public String getImagen_front() {
		return imagen_front;
	}
	public void setImagen_front(String imagen_front) {
		this.imagen_front = imagen_front;
	}
	public String getImagen_left() {
		return imagen_left;
	}
	public void setImagen_left(String imagen_left) {
		this.imagen_left = imagen_left;
	}
	public String getImagen_right() {
		return imagen_right;
	}
	public void setImagen_right(String imagen_right) {
		this.imagen_right = imagen_right;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	
	 
	 
}
