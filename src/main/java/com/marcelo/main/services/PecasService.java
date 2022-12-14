package com.marcelo.main.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.marcelo.main.entities.Peca;
import com.marcelo.main.entities.PecaDto;
import com.marcelo.main.repositories.PecasRepository;

@Service
public class PecasService {

	
	@Autowired
	PecasRepository pr;
	
	@Transactional
	public void cadastrarPeca(Peca peca) {
		if (pr.existsById(peca.getCodigoDeBarras()))
			throw new RuntimeException();
		
		pr.save(peca);
		
	}
	
	@Transactional(readOnly = true)
	public List<PecaDto> buscarPecas() {
		List<Peca> pecas = pr.findAll();
		return PecaDto.toDto(pecas);
		
	}
	
	@Transactional(readOnly = true)
	public PecaDto buscarPeca(Long codBarra) {
		
		if (pr.existsById(codBarra)) {
			Peca peca = pr.findById(codBarra).get();
			return PecaDto.toDto(peca);
		}
		
		throw new ResponseStatusException(HttpStatus.NOT_FOUND);
	}
		

	@Transactional
	public void alterarPeca(Long codBarra, Peca peca) {
		if (pr.existsById(codBarra)) {
			Optional<Peca> pecaUpdate = pr.findById(codBarra);
			pecaUpdate.get().setNome(peca.getNome());
			pecaUpdate.get().setFabricante(peca.getFabricante());
			pecaUpdate.get().setModeloDoCarro(peca.getModeloDoCarro());
			pecaUpdate.get().setCategoria(peca.getCategoria());
			pecaUpdate.get().setPrecoDeCusto(peca.getPrecoDeCusto());
			pecaUpdate.get().setPrecoDeVenda(peca.getPrecoDeVenda());
			
			pr.save(pecaUpdate.get());
			return;
		}
		
		throw new RuntimeException();
		
	}

	@Transactional
	public void removerPeca(Long codBarra) {
		
		if (pr.existsById(codBarra)) {
			pr.deleteById(codBarra);
			return;
		}
		throw new RuntimeException();
		
	}
}
