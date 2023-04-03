package generation.javongus.html.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import generation.javongus.html.model.Estilo;
import generation.javongus.html.repository.EstiloRepository;

@Service
public class EstiloServices {
//	Instancia
	private final EstiloRepository estiloRe;

	@Autowired
	public EstiloServices(EstiloRepository estiloRe) {
		this.estiloRe = estiloRe;
	}
	
//	CREATE
	public void crearEstilo(Estilo estilo) {
		estiloRe.save(estilo);
	}
//	READ
	public List<Estilo> leerEstilos() {
		return estiloRe.findAll();
	}
	public Estilo leerEstilo(Long id) {
		return estiloRe.findById(id).orElseThrow(()-> new IllegalStateException("El estilo "
				+ "con el id " +id+  " no existe"));
	}
//	UPDATE (PENDIENTE)
//	DELETE
	public void borrarEstilo(Long id) {
		if(estiloRe.existsById(id)) {
			estiloRe.deleteById(id);
		}else {
			System.out.println("El estilo con el id "+id+" no existe");
		}
	}
	
}
