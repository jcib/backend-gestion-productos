package com.joselinex.polloloko.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.joselinex.polloloko.model.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto,Long> {

	// magia potagia...
	public List<Producto> findByCategoria(String categoria);
	

	
	
}
