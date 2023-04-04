package generation.javongus.html.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import generation.javongus.html.model.CarritoProducto;

import generation.javongus.html.repository.CarritoProductoRepository;


@Service
public class CarritoProductoService {
	private final CarritoProductoRepository carritoProductoRe;
//	private final CarritoRepository carritoRe;
//	Se iba a usar para crear el carrito junto con el producto pero no se hizo
	
	@Autowired
	public CarritoProductoService(CarritoProductoRepository carritoProductoRe) {
		this.carritoProductoRe = carritoProductoRe;
	}
	
//	CREATE
//	No tiene método create por que siempre se van a crear como parte de un carrito!
	
//	READ
	public List<CarritoProducto> leerCarritoProducto() {
		return carritoProductoRe.findAll();
	}

//	DELETE
//	Incluso esta función talvez no sea buena, por que tiene que trabajar en conjunto con el carrito
	public void borrarEstilo(Long id) {
		if(carritoProductoRe.existsById(id)) {
			carritoProductoRe.deleteById(id);
		}else {
			System.out.println("El carritoPro con el id "+id+" no existe");
		}
	}
}
