package generation.javongus.html.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import generation.javongus.html.model.CarritoProducto;
import generation.javongus.html.services.CarritoProductoService;

@CrossOrigin(origins = "*", 
methods = { RequestMethod.GET, RequestMethod.POST, 
		RequestMethod.DELETE, RequestMethod.PUT })

@RestController
@RequestMapping(path = "/html/carritop/")
public class CarritoProductoController {
	private final CarritoProductoService carritoProductoSer;
	
	@Autowired
	public CarritoProductoController(CarritoProductoService carritoProductoSer) {
		this.carritoProductoSer = carritoProductoSer;
	}
//	GET 
	@GetMapping
	public List<CarritoProducto> getCarrito() {
		return carritoProductoSer.leerCarritoProducto();
	}
//	POST
//	@PostMapping("/{carritoId}/{productoId}")
//    public CarritoProducto addProductToCart(@PathVariable Long carritoId, @PathVariable Long productoId, @RequestParam Integer cantidad) {
//        return carritoProductoSer.addProductToCart(carritoId, productoId, cantidad);
//    }
}
