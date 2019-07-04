package com.joselinex.polloloko.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.joselinex.polloloko.model.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido,Long>{

	public List<Pedido> findByMesa(int mesa);
	
	public List<Pedido> findByMesaContaining(int numero);
	
}
