package generation.javongus.html.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import generation.javongus.html.model.MetodoPago;
import generation.javongus.html.repository.MetodoPagoRepository;

@Service
public class MetodoPagoServices {
	private MetodoPagoRepository metodoPRe;

	@Autowired
	public MetodoPagoServices(MetodoPagoRepository metodoPRe) {
		super();
		this.metodoPRe = metodoPRe;
	}
	
//	CREATE
	public void crearMetodoP(MetodoPago metodoP) {
		metodoPRe.save(metodoP);
	}
//	READ
	public List<MetodoPago> leerMetodos() {
		return metodoPRe.findAll();
	}
	public MetodoPago leerMetodo(Long id) {
		return metodoPRe.findById(id).orElseThrow(()-> new IllegalStateException("El método"
				+ "con el id" +id+  " no existe"));
	}
//	SIN UPDATE
//	DELETE
	public void borrarMetodo(Long id) {
		if(metodoPRe.existsById(id)) {
			metodoPRe.deleteById(id);
		}else {
			System.out.println("El método con el id "+id+" no existe");
		}
	}
}
