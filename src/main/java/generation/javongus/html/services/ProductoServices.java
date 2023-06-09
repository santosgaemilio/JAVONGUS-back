package generation.javongus.html.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import generation.javongus.html.model.Estilo;
import generation.javongus.html.model.Producto;
import generation.javongus.html.model.ProductoEstiloDTO;

import generation.javongus.html.repository.EstiloRepository;
import generation.javongus.html.repository.ProductoRespository;

@Service
public class ProductoServices {
//	Instancia del repositiorio
	private final ProductoRespository productoRe;
	private final EstiloRepository estiloRe;

	@Autowired
	public ProductoServices(ProductoRespository productoRe,
			EstiloRepository estiloRe) {
		this.productoRe = productoRe;
		this.estiloRe = estiloRe;
	}
	
//	CREATE
	public void crearProducto(Producto producto) {
		Optional <Producto> prodByName = 
				productoRe.findByNombre(producto.getNombre());
		if (prodByName.isPresent()) {
			throw new IllegalStateException("El producto con el nombre "
	                  + "[" + producto.getNombre() + "] ya existe.");
		}else {
			productoRe.save(producto);
		}

	}
	//	crear con estilo al mismo tiempo
	
	public void createProductoWithEstilo(ProductoEstiloDTO productoEstiloDTO) {
		Producto producto = productoEstiloDTO.getProducto();
	    Estilo estilo = productoEstiloDTO.getEstilo();
	    
		Estilo estiloExistente = buscarEstiloExistente(estilo);
	    if (estiloExistente != null) {
	    	estiloExistente.setProducto(producto);
	    	producto.getEstilos().add(estiloExistente);
	      
	    } else {
	      estilo = estiloRe.save(estilo);
	      producto.getEstilos().add(estilo);
	      estilo.setProducto(producto);
	    }
	    productoRe.save(producto);
    }
//	///////////auxiliar///////////////////////////////////////////
	private Estilo buscarEstiloExistente(Estilo estilo) {
	    List<Estilo> estilos = estiloRe
	        .buscarPorAtributosIgnorandoMayusculas(estilo.getHexa(), estilo.getImagen_back(), estilo.getImagen_front(), estilo.getImagen_left(), estilo.getImagen_right());
	    if (!estilos.isEmpty()) {
	      return estilos.get(0);
	    }
	    return null;
	}
//	READ
	public List<Producto> leerProductos() {
		return productoRe.findAll();
	}
	public Producto leerProducto(Long id) {
		return productoRe.findById(id).orElseThrow(()-> new IllegalStateException("El producto"
				+ "con el id" +id+  " no existe"));
	}
	// Encuentra productos dentro del límite de precios	
	public List<Producto> precioProducto(Double start, Double end){
		return productoRe.findByPrecioBetween(start, end);
	}
	//	Order
	public List<Producto> leerProductosO(Integer order) {
		if (order == 1) {
	        return productoRe.findAllOrderedA();
	    }else {
	    	if(order == 2) {
	    		return productoRe.findAllOrderedD();
	    	}
	    	
	    }
		return null;
	    
	}
	//	Marca
	public List<Producto> leerProductosM(Long marca_id) {
		return productoRe.findByMarca(marca_id);
	}
	//	Tipo
	public List<Producto> leerProductosT(String tipo) {
		return productoRe.findByTipo(tipo);
	}
	//	Target
	public List<Producto> leerProductosTa(Integer target) {
		return productoRe.findByTarget(target);
	}

	
	
//	UPDATE
	public void actualizarProducto(Long prodId,String nombre, String descripcion, Integer cantidad, Double precio,
			Integer target, String tipo, Long marcaId, Long estiloId) {
		if(productoRe.existsById(prodId)) {
//			Esta onda es una función vieja que talvez no se debería de usar
			@SuppressWarnings("deprecation")
			Producto productoABuscar = productoRe.getById(prodId);
			if(nombre!= null) productoABuscar.setNombre(nombre);
			if (descripcion!= null) productoABuscar.setDescripcion(descripcion);
	        if (precio != null) productoABuscar.setPrecio(precio);
//	        CANTIDAD ////////////////////////////////////////
	        if (cantidad <0) {
	        	if ((productoABuscar.getCantidad() + cantidad) < 0) {
	        		productoABuscar.setCantidad(0);
	        	}else {
	        		productoABuscar.setCantidad(productoABuscar.getCantidad()+cantidad);
	        	}
	        }else {
	        	productoABuscar.setCantidad(productoABuscar.getCantidad()+cantidad);
	        }
//	        /////////////////////////////////////////////////
	        if (target!=null) productoABuscar.setTarget(target);
	        if (tipo!=null) productoABuscar.setTipo(tipo);
	        if(marcaId!=null) productoABuscar.setMarca_id(marcaId);
	        if(estiloId!=null) {
	        	if(estiloRe.existsById(estiloId)) {
	        		@SuppressWarnings("deprecation")
					Estilo estilo = estiloRe.getById(estiloId);
	        		productoABuscar.getEstilos().add(estilo);
	        		estilo.setProducto(productoABuscar);
	        	}else {
	        		System.out.println("El estilo no existe");
	        	}
	        }
	        productoRe.save(productoABuscar);

		}else {
			System.out.println("El producto con el id "+prodId+" no existe");
		}
	}
//	DELETE
	public void borrarProducto(Long id) {
		if(productoRe.existsById(id)) {
			productoRe.deleteById(id);
		}else {
			System.out.println("El producto con el id "+id+" no existe");
		}
	}
}
