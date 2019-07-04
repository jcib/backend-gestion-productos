package com.joselinex.polloloko.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.joselinex.polloloko.model.Camarero;

@Repository
public interface CamareroRepository extends JpaRepository<Camarero,Long> {

}
