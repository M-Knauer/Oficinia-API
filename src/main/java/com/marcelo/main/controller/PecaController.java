package com.marcelo.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.marcelo.main.entities.Peca;
import com.marcelo.main.entities.PecaDto;
import com.marcelo.main.services.PecasService;

@RestController
@RequestMapping("/pecas")
public class PecaController {
	
	@Autowired
	PecasService ps;
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public void cadastrarPeca(@RequestBody Peca peca) {
		try {
			ps.cadastrarPeca(peca);
			
		} catch (RuntimeException e) {
			throw new ResponseStatusException(HttpStatus.NOT_MODIFIED);
			
		}
		
	}
	
	@GetMapping
	@ResponseStatus(code = HttpStatus.FOUND)
	public List<PecaDto> buscarPecas() {
		try {
			return ps.buscarPecas();
			
		} catch (RuntimeException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@GetMapping(path = "{codBarra}")
	@ResponseStatus(code = HttpStatus.FOUND)
	public PecaDto buscarPeca(@PathVariable Long codBarra) {
		try {
			return ps.buscarPeca(codBarra);
			
		} catch (RuntimeException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
			
		}
		
	}
	
	@PutMapping(path = "{codBarra}")
	public void alterarPeca(@PathVariable Long codBarra, @RequestBody Peca peca ) {
		try {
			ps.alterarPeca(codBarra, peca);
			
		} catch (RuntimeException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
			
		}
	}
	
	@DeleteMapping(path = "{codBarra}")
	public void removerPeca(@PathVariable Long codBarra) {
		try {
			ps.removerPeca(codBarra);
			
		} catch (RuntimeException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
			
		}
		
	}
	
}
