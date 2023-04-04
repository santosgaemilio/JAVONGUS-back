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

import generation.javongus.html.model.Estilo;
import generation.javongus.html.services.EstiloServices;

@CrossOrigin(origins = "*", 
methods = { RequestMethod.GET, RequestMethod.POST, 
		RequestMethod.DELETE, RequestMethod.PUT })
@RestController
@RequestMapping(path = "/html/estilo/")
public class EstiloController {
	private final EstiloServices estiloSer;
	
	@Autowired
	public EstiloController(EstiloServices estiloSer) {
		this.estiloSer = estiloSer;
	}
	
//	GET
	@GetMapping
	public List<Estilo> getEstilo() {
		return estiloSer.leerEstilos();
	}
	 @GetMapping("/last")
	    public Estilo getLastUser() {
	        return estiloSer.findLastUser();
	    }
	@GetMapping(path = "/{estiloId}") 
	public Estilo getEstilo(@PathVariable("estiloId") Long estiloId) {
		return estiloSer.leerEstilo(estiloId);
	}
	
//	POST
	@PostMapping
	public void postEstilo(@RequestBody Estilo estilo) {
		estiloSer.crearEstilo(estilo);
	}
//	DELETE
	@DeleteMapping(path = "{estiloId}")
	public void deleteEstilo(@PathVariable("estiloId") Long estiloId) {
		estiloSer.borrarEstilo(estiloId);
	}
	
}
