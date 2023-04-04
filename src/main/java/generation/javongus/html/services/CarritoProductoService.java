package generation.javongus.html.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import generation.javongus.html.model.Carrito;
import generation.javongus.html.model.CarritoProducto;

import generation.javongus.html.model.Producto;
import generation.javongus.html.repository.CarritoProductoRepository;
import generation.javongus.html.repository.CarritoRepository;

@Service
public class CarritoProductoService {
	private final CarritoProductoRepository carritoProductoRe;
	private final CarritoRepository carritoRe;
	
	@Autowired
	public CarritoProductoService(CarritoProductoRepository carritoProductoRe,CarritoRepository carritoRe) {
		this.carritoProductoRe = carritoProductoRe;
		this.carritoRe = carritoRe;
	}
	
//	CREATE
	
	
	//	
	
	
//	READ
	public List<CarritoProducto> leerCarritoProducto() {
		return carritoProductoRe.findAll();
	}
//	public List<CarritoProducto> getCartProductsByCartId(Long cartId) {
//        return carritoProductoRe.findById(cartId);
//    }
//	DELETE
	public void borrarEstilo(Long id) {
		if(carritoProductoRe.existsById(id)) {
			carritoProductoRe.deleteById(id);
		}else {
			System.out.println("El carritoPro con el id "+id+" no existe");
		}
	}
}
