package com.joselinex.polloloko.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.joselinex.polloloko.model.Producto;
import com.joselinex.polloloko.repositories.ProductoRepository;

@RestController
public class ProductoController {
	
	@Autowired
	private ProductoRepository productoRepository;
	
	@RequestMapping("/productos")
	public List<Producto> getAll(){
		
		return productoRepository.findAll();
	}
	
	/*-----------------*/
	
	@RequestMapping(value="/productos", 
	        method = RequestMethod.POST,
	        consumes=MediaType.APPLICATION_JSON_VALUE)
	public String crearProductos (@RequestBody Producto producto) {
		
		productoRepository.save(producto);
		
		return "Producto añadido correctamente.";
		
	}
	
	/*-----------------*/
	
	@RequestMapping(value="/productos/{category}",
					method=RequestMethod.GET)
	public List<Producto> getByCategory (@PathVariable ("category") String categoria) {
		
		
		// vamos a engañar para probar....
		
		//return productoRepository.getByCategoria(categoria);
		//return productoRepository.findByPrecioBetween(10,15);
		return productoRepository.findByCategoria(categoria);
		
		
		
	}
	
	/*-----------------*/
	
	// Cuando queremos filtrar datos, normalmente los valores del filtro van como 
	// parámetros en la URL y no como pathvariable
	
	// ejemplo: http://localhost:8080/productos?familia=CAFE
	
	// Pero tú me has preguntado otra cosa... sonre el productoRepository
	
	// ProductoRepository es un interface que Spring implementa automáticamente
	// Hace muchas cosas, de las cuales hay bastante de ellas mágicas...
	
	// Te lo demuestro...
	
	
	
	/*-----------------*/
	
	@RequestMapping(value="/productos",
					method=RequestMethod.PUT,
					consumes=MediaType.APPLICATION_JSON_VALUE)
	public String actualizar(@RequestBody Producto producto) {
		
		System.out.println("Vamos a actualizar: " + producto);
		productoRepository.save(producto);
		
		return "Producto actualizado.";
		
	}

}
