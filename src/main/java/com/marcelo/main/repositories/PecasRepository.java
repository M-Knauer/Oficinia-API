package com.marcelo.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marcelo.main.entities.Peca;

public interface PecasRepository extends JpaRepository<Peca, Long> {

	
}
