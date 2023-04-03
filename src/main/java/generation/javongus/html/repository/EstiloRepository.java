package generation.javongus.html.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import generation.javongus.html.model.Estilo;

public interface EstiloRepository extends JpaRepository<Estilo, Long>{
	@Query(value = "SELECT * FROM estilos WHERE LOWER(hexa) = LOWER(:hexa) AND LOWER(imagen_back) = LOWER(:imagen_back) AND LOWER(imagen_front) = LOWER(:imagen_front) AND LOWER(imagen_left) = LOWER(:imagen_left) AND LOWER(imagen_right) = LOWER(:imagen_right)", nativeQuery = true)
	  List<Estilo> buscarPorAtributosIgnorandoMayusculas(@Param("hexa") String hexa, @Param("imagen_back")String imagen_back, @Param("imagen_front")String imagen_front,@Param("imagen_left") String imagen_left,@Param("imagen_right") String imagen_right);
}
