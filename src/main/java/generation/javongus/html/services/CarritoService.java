package generation.javongus.html.services;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import generation.javongus.html.model.Carrito;
import generation.javongus.html.model.CarritoProducto;
import generation.javongus.html.model.MetodoPago;
import generation.javongus.html.model.Producto;
import generation.javongus.html.repository.CarritoProductoRepository;
import generation.javongus.html.repository.CarritoRepository;
import generation.javongus.html.repository.MetodoPagoRepository;
import generation.javongus.html.repository.ProductoRespository;

@Service
public class CarritoService {
	private CarritoRepository carritoRe;
	private CarritoProductoRepository carritoPRe;
	private ProductoRespository productoRe;
	private MetodoPagoRepository metodoRe;
	
	@Autowired
	public CarritoService(CarritoRepository carritoRe,CarritoProductoRepository carritoPRe,ProductoRespository productoRe, MetodoPagoRepository metodoRe) {
		this.carritoRe = carritoRe;
		this.carritoPRe = carritoPRe;
		this.productoRe = productoRe;
		this.metodoRe = metodoRe;
	}
//	CREATE
	public Carrito crearCarrito() {
		Carrito carrito = new Carrito();
		return carritoRe.save(carrito);
	}
//	agregar
	@SuppressWarnings("deprecation")
	public void addProductToCart(Long carritoId, Long prodId, Integer cantidad) {
		Carrito carrito = carritoRe.getById(carritoId);
		Producto producto = productoRe.getById(prodId);
		CarritoProducto carritoProducto = new CarritoProducto();
		carritoProducto.setCarrito(carrito);
		carritoProducto.setProducto(producto);
		carritoProducto.setCantidad(cantidad);
		carrito.getCarritoProducto().add(carritoProducto);
		carritoRe.save(carrito);
		carritoPRe.save(carritoProducto);
			
    }
//	eliminar
	 public void removeFromCart(CarritoProducto carritoProducto) {
	        Carrito carrito = carritoProducto.getCarrito();
	        carrito.getCarritoProducto().remove(carritoProducto);
	        
	        carritoPRe.delete(carritoProducto);
	 }
	
//	READ
	public List<Carrito> leerCarritos() {
		return carritoRe.findAll();
	}
	public Carrito leerCarrito(Long id) {
		return carritoRe.findById(id).orElseThrow(()-> new IllegalStateException("El carrito "
				+ "con el id " +id+  " no existe"));
	}
//	UPDATE (PENDIENTE)
	public void agregarMetodo(Long carrito_id, Long metodo_id) {
		if(carritoRe.existsById(carrito_id)){
			@SuppressWarnings("deprecation")
			Carrito carritoABuscar = carritoRe.getById(carrito_id);
			if(metodo_id!=null && metodoRe.existsById(metodo_id)) {
				@SuppressWarnings("deprecation")
				MetodoPago metodo = metodoRe.getById(metodo_id);
				carritoABuscar.setMetodo(metodo);
				metodo.getCarrito().add(carritoABuscar);
				carritoRe.save(carritoABuscar);
				metodoRe.save(metodo);
			}else {
				System.out.println("El método no existe");
			}
		}else {
			System.out.println("El carrito no existe");
		}
	}
//	DELETE
	
	public void borrarCarrito(Long id) {
		if(carritoRe.existsById(id)) {
			carritoRe.deleteById(id);
		}else {
			System.out.println("El carrito con el id "+id+" no existe");
		}
	}
	
	
}
