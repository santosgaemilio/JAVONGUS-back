package generation.javongus.html.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import generation.javongus.html.model.Carrito;

public interface CarritoRepository extends JpaRepository<Carrito, Long>{
	
}
