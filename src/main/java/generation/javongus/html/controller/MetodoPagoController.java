package generation.javongus.html.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import generation.javongus.html.model.MetodoPago;
import generation.javongus.html.services.MetodoPagoServices;

@CrossOrigin(origins = "*", 
methods = { RequestMethod.GET, RequestMethod.POST, 
		RequestMethod.DELETE, RequestMethod.PUT })
@RestController
@RequestMapping(path = "/html/metodoPago/")
public class MetodoPagoController {
	private final MetodoPagoServices metodoPSer;
	
	@Autowired
	public MetodoPagoController(MetodoPagoServices metodoPSer) {
		super();
		this.metodoPSer = metodoPSer;
	}
	
//	GET
	@GetMapping
	public List<MetodoPago> getMetodoP(){
		return metodoPSer.leerMetodos();
	}
	@GetMapping(path = "{metodoId}")
	public MetodoPago getMetodoP(@PathVariable("metodoId") Long metodoId) {
		return metodoPSer.leerMetodo(metodoId);
	}
//	POST
	@PostMapping
	public void postMetodoP(@RequestBody MetodoPago metodoPago) {
		metodoPSer.crearMetodoP(metodoPago);
	}
//	DELETE
	@DeleteMapping(path = "{metodoId}")
	public void deleteMetodo(@PathVariable("metodoId") Long metodoId) {
		metodoPSer.borrarMetodo(metodoId);
	}
}
