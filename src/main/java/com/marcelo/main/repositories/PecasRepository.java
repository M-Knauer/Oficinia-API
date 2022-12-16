package com.marcelo.main.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marcelo.main.entities.Peca;

public interface PecasRepository extends JpaRepository<Peca, Long> {

	Optional<Peca> findByCodigoDeBarras(Long codBarras);
	Boolean existsByCodigoDeBarras(Long codBarras);
	void deleteByCodigoDeBarras(Long codBarras);
	List<Peca> findByNomeStartingWith(String txt);
	List<Peca> findByModeloDoCarroContaining(String modelo);
	List<Peca> findByCategoria(Integer categoria);
	
}
