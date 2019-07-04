package com.joselinex.polloloko.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.joselinex.polloloko.model.Pedido;
import com.joselinex.polloloko.repositories.PedidoRepository;

@RestController
public class PedidoController {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	/*----------------------------------*/
	
	@RequestMapping("/pedidos")
	public List<Pedido> getAll(){
		
		return pedidoRepository.findAll();
	}
	
	/*----------------------------------*/
	
	@RequestMapping(value="/pedidos", 
	        method = RequestMethod.POST,
	        consumes = MediaType.APPLICATION_JSON_VALUE)
	public String crearPedidos (@RequestBody Pedido pedido) {
		
		pedidoRepository.save(pedido);
		
		return "Pedido añadido.";
	}

	/*----------------------------------*/
	
	@RequestMapping(value="/pedidos/mesas",
					method=RequestMethod.GET)
	public List<Pedido> getByName (@RequestParam ("mesa") int mesa) {
		
		return pedidoRepository.findByMesa(mesa);
		
		
	}
	
	/*----------------------------------*/
	
	@RequestMapping(value="/pedidos/find",
			method=RequestMethod.GET)
	public List<Pedido> findByMesaContaining (@RequestParam ("numero") int numero) {

		return pedidoRepository.findByMesaContaining(numero);


}
	
}
