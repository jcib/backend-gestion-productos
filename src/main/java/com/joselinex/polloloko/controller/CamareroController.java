package com.joselinex.polloloko.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.joselinex.polloloko.model.Camarero;
import com.joselinex.polloloko.repositories.CamareroRepository;

@RestController
public class CamareroController {

	@Autowired
	private CamareroRepository camareroRepository;
	
	
	// ******************************************************
	// ******************************************************
	// ******************************************************
	// ******************************************************
	// ******************************************************
	
	
	@RequestMapping("/camareros")
	public List<Camarero> getAll(){
		System.out.println("ENTRAMOS EN GET");
		return camareroRepository.findAll();
		
	}
	
	
	// ******************************************************
	// ******************************************************
	// ******************************************************
	// ******************************************************
	// ******************************************************
	
	// End-point para crear un camarero en el sistema
	// Es importante que observeis que la estructura del 
	// objeto JSON que nos llega tiene que coincidir con la
	// clase de Java en nuestro modelo.
	
	// En el caso de un camarero es muy sencillo, porque los
	// dos unicos atributos son:
	//
	//  Un id (tipo Long)
	//  Un nombre (tipo String)
	//
	
	// En cuanto al RequestMapping,observad lo siguiente...
	
	// - si desde Postman (o el cliente que sea) no se indica
	//   el método POST aquí no entramos!
	// - si desde Postman (o el cliente que sea) no se añade
	//   un header "content-type"="application/json" aquí no
	//   entramos!
	// - si la URL no es /camareros aquí no entramos.
	
	// RESUMEN: Tres requisitos que se han de cumplir a la vez
	
	// Ahora vamos a Postman...
	
	// Vaya silencio!!! Podeis hablar...
	
	@RequestMapping(value="/camareros", //1
			        method = RequestMethod.POST, //2
			        consumes=MediaType.APPLICATION_JSON_VALUE) //3
	public String crearCamarero(@RequestBody Camarero camarero) {
		
		System.out.println("ENTRAMOS EN POST...");
		
		// El parámetro camarero recoge por "arte de magia"
		// los valores del objeto JSON que llega en el body
		// de la petición (requestBody)
		
		// Una vez tenemos camarero, llamamos al método save
		// para crearlo (persistirlo, guardarlo...) en la
		// base de datos...
		
		camareroRepository.save(camarero);
		
		// FIN
		
		return "ok";
	}
	
	
	// ******************************************************
	// ******************************************************
	// ******************************************************
	// ******************************************************
	// ******************************************************
	
	
	// Ahora vamos devolver un camarero a partir de su código...
	// El código llega como pathvariable
	
	
	@RequestMapping(value="/camareros/{codigo}",
					method=RequestMethod.GET)
	public Camarero getById(@PathVariable ("codigo") Long id) {
		
		Optional<Camarero> optional = camareroRepository.findById(id);
		
		Camarero camarero = optional.isPresent() ? optional.get(): null;
		System.out.println(camarero.toString());
		return camarero;
		
		
		
	}
	
	
	
	// ******************************************************
	// ******************************************************
	// ******************************************************
	// ******************************************************
	// ******************************************************
	
	// Ahora vamos a actualizar.
	// El camarero que nos llega ha de llegar completito con su
	// código!!! El código ha de existir!!!!
	// El JSON llega de nuevo en el body del request
	// también llega el header "content-type" con valor "application/json"
	// El método es PUT
	
	@RequestMapping(value="/camareros",
					method=RequestMethod.PUT,
					consumes=MediaType.APPLICATION_JSON_VALUE)
	public String actualizar(@RequestBody Camarero camarero) {
		System.out.println("vamos a actualizar a : " + camarero);
		camareroRepository.save(camarero); // se utilizar save igual que al crear!
		return "ok";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
