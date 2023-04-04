package generation.javongus.html.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import generation.javongus.html.model.Carrito;

import generation.javongus.html.services.CarritoService;

@CrossOrigin(origins = "*", 
methods = { RequestMethod.GET, RequestMethod.POST, 
		RequestMethod.DELETE, RequestMethod.PUT })

@RestController
@RequestMapping(path = "/html/carrito/")
public class CarritoController {
	private final CarritoService carritoSer;
	
	@Autowired
	public CarritoController(CarritoService carritoSer) {
		this.carritoSer = carritoSer;
	}
//	GET
	@GetMapping
	public List<Carrito> getCarrito() {
		return carritoSer.leerCarritos();
	}
	@GetMapping(path = "/{carritoId}") 
	public Carrito getCarrito(@PathVariable("carritoId") Long carritoId) {
		return carritoSer.leerCarrito(carritoId);
	}
//	POST
	@PostMapping
	public void postCarrito() {
		carritoSer.crearCarrito();
	}
//	///////////////// TEST //////////////////////////////
//	ADD A PRODUCT TO A CART (El carrito debe estar creado)
	@PostMapping("/add")
	public void addCarrito(@RequestParam("carritoId") Long carritoId,
			@RequestParam("productoId") Long productoId, @RequestParam("cantidad") Integer cantidad){
		carritoSer.addProductToCart(carritoId, productoId, cantidad);
	}
//	//////////////////////////////////////////////////////
//	DELETE
	@DeleteMapping(path = "{carritoId}")
	public void deleteCarrito(@PathVariable("carritoId") Long carritoId) {
		carritoSer.borrarCarrito(carritoId);
	}
}
